package questionnaire.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import questionnaire.database.*;
import questionnaire.utils.QRCodeUtils;
import questionnaire.web.dao.ChoiceDao;
import questionnaire.web.dao.QuestionDao;
import questionnaire.web.dao.QuestionnaireDao;
import questionnaire.web.dao.QuestionResultDao;
import questionnaire.web.entity.QuestionAnswerForm;
import questionnaire.web.entity.QuestionnaireAnswerForm;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 填写问卷业务逻辑的Controller
 */
@Controller
@RequestMapping(value = "/answerQuestionnaire")
public class QuestionnaireAnswerController {
    /**
     * 问卷Dao
     */
    @Autowired
    private QuestionnaireDao questionnaireDao;
    /**
     * 问题Dao
     */
    @Autowired
    private QuestionDao questionDao;
    /**
     * 选项Dao
     */
    @Autowired
    private ChoiceDao choiceDao;
    /**
     * 答卷结果Dao
     */
    @Autowired
    private QuestionResultDao questionResultDao;

    /**
     * 访问问卷填写页面
     *
     * @param questionnaireId 问卷ID
     * @param model Model
     * @return 对应问卷ID的问卷填写页面
     */
    @RequestMapping(value = "/{questionnaireId}", method = RequestMethod.GET)
    public String getAnswerQuestionnairePage(@PathVariable("questionnaireId") String questionnaireId, Model model){
        // 获取问卷ID对应的问卷对象
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        if (!questionnaireTable.getIsChecked()){
            // 问卷未审核,返回提示页面
            return "unChecked";
        }
        model.addAttribute("questionnaire", questionnaireTable);

        return "questionnaire";
    }


    /**
     * Generate a QR code based on the questionnaire URL and return to the user interface for downloading
     * @param questionnaireId 问卷ID
     * @param request 请求
     * @param response 响应
     * @return 请求结果的状态
     */
    @RequestMapping(value = "/getQRCode/{questionnaireId}", method = GET)
    public String addOneQRCode(@PathVariable("questionnaireId") String questionnaireId,HttpServletRequest request, HttpServletResponse response) {
        String url="http://127.0.0.1:8080/answerQuestionnaire/"+questionnaireId;
        System.out.println(url);
        QuestionnaireTable answerTable= questionnaireDao.getOneQuestionnaire(questionnaireId);
        BufferedImage image = null;
        String content = answerTable.getTableName();
        try {
            //Write the QR code image to the response in the form of byte stream
            image = QRCodeUtils.generateQrCodeBack(url, content);
            ServletOutputStream os = response.getOutputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            byte[] imageBytes = baos.toByteArray();
            os.write(imageBytes);
            os.flush();
            os.close();
            response.setHeader("Content-Disposition", "attachment");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    /**
     * 提交答卷结果的API,前端js函数发送的POST请求的Body——传输的答卷结果数据的JSON串
     *
     * @param formDataJson 答卷结果数据的JSON串
     * @return 问卷提交成功页面的路径,前端js函数负责重定向到该页面
     */
    @RequestMapping(value = "/api/submitForm", method = RequestMethod.POST)
    @ResponseBody
    public String dealSubmittedForm(@RequestBody String formDataJson){
        // 将前端传入的表单数据转化为QuestionnaireAnswerForm对象
        QuestionnaireAnswerForm questionnaireResultForm = JSON.parseObject(formDataJson, QuestionnaireAnswerForm.class);
        // 获取提交的表单数据对应的问卷对象
        QuestionnaireTable questionnaireTable =
                questionnaireDao.getOneQuestionnaire(questionnaireResultForm.getQuestionnaireId());
        // 创建问卷回答记录对象
        QuestionnaireResult questionnaireResult = new QuestionnaireResult(null, questionnaireTable, new HashSet<>());
        // 将问卷回答记录添加到数据库
        String questionnaireResultId = questionResultDao.addQuestionnaireResult(questionnaireResult);
        questionnaireResult.setResultId(questionnaireResultId);
        // 获取提交的表单中的答案列表
        ArrayList<QuestionAnswerForm> questionAnswerForms =
                (ArrayList<QuestionAnswerForm>) questionnaireResultForm.getQuestionAnswers();

        // 遍历答案列表,取出某一题的答案
        for (QuestionAnswerForm questionAnswerForm : questionAnswerForms){
            // 获取该答案所对应的题目对象
            QuestionType question = questionDao.readOneQuestion(questionAnswerForm.getQuestionId());

            if (question instanceof QText){ // 文本填空题
                QTextResult qTextResult = new QTextResult(null, true, question,
                        question.getQuestionOrder(), questionnaireResult, questionAnswerForm.getAnswer().get(0));
                // 将答案写入数据库
                questionResultDao.addQuestionTypeResult(qTextResult);
            }else { // 选择题
                // 选择题答题记录对象
                QChooseResult qChooseResult = new QChooseResult(null, false, question, question.getQuestionOrder(),
                        questionnaireResult, new HashSet<>());
                String qChooseResultId = questionResultDao.addQuestionTypeResult(qChooseResult);
                qChooseResult.setResultId(qChooseResultId);

                // 遍历答案列表,answer为选中的选项的ID,取出选择的每一个选项,若为单选题则仅有一个答案,多选题则有多个
                for (String answer : questionAnswerForm.getAnswer()){
                    // 获取被选中的选项对象
                    Choice choice = choiceDao.readOneChoice(answer);
                    ChoiceResult choiceResult = new ChoiceResult(null, choice.getcOrder(), choice, qChooseResult);
                    // 将选择结果写入数据库
                    questionResultDao.addChoiceResult(choiceResult);
                }
            }
        }

        // 成功提交页面的url,由前端js函数重定向到该页面
        return "/surveySystem/answerQuestionnaire/successSubmitted";
    }

    /**
     * 访问成功提交页面
     *
     * @return 成功提交页面
     */
    @RequestMapping(value = "/successSubmitted")
    public String getSuccessSubmittedPage(){
        return "submitted";
    }
}
