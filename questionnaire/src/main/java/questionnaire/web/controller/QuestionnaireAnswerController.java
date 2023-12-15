package questionnaire.web.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import questionnaire.database.*;
import questionnaire.web.dao.ChoiceDao;
import questionnaire.web.dao.QuestionDao;
import questionnaire.web.dao.QuestionnaireDao;
import questionnaire.web.dao.QuestionResultDao;
import questionnaire.web.entity.QuestionAnswerForm;
import questionnaire.web.entity.QuestionnaireAnswerForm;

import java.util.ArrayList;
import java.util.HashSet;

@Controller
@RequestMapping(value = "/answerQuestionnaire")
public class QuestionnaireAnswerController {
    @Autowired
    private QuestionnaireDao questionnaireDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private ChoiceDao choiceDao;
    @Autowired
    private QuestionResultDao questionResultDao;

    @RequestMapping(value = "/{questionnaireId}", method = RequestMethod.GET)
    public String getAnswerQuestionnairePage(@PathVariable("questionnaireId") String questionnaireId, Model model){
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        if (!questionnaireTable.getIsChecked()){
            return "unChecked";
        }
        model.addAttribute("questionnaire", questionnaireTable);

        return "questionnaire";
    }

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

        for (QuestionAnswerForm questionAnswerForm : questionAnswerForms){
            QuestionType question = questionDao.readOneQuestion(questionAnswerForm.getQuestionId());

            if (question instanceof QText){
                QTextResult qTextResult = new QTextResult(null, true, question,
                        question.getQuestionOrder(), questionnaireResult, questionAnswerForm.getAnswer().get(0));

                questionResultDao.addQuestionTypeResult(qTextResult);
            }else {
                QChooseResult qChooseResult = new QChooseResult(null, false, question, question.getQuestionOrder(),
                        questionnaireResult, new HashSet<>());
                String qChooseResultId = questionResultDao.addQuestionTypeResult(qChooseResult);
                qChooseResult.setResultId(qChooseResultId);

                for (String answer : questionAnswerForm.getAnswer()){
                    Choice choice = choiceDao.readOneChoice(answer);
                    ChoiceResult choiceResult = new ChoiceResult(null, choice.getcOrder(), choice, qChooseResult);
                    questionResultDao.addChoiceResult(choiceResult);
                }
            }
        }

        return "/answerQuestionnaire/successSubmitted";
    }

    @RequestMapping(value = "/successSubmitted")
    public String getSuccessSubmittedPage(){
        return "submitted";
    }
}
