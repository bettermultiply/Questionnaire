package questionnaire.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import questionnaire.database.*;
import questionnaire.web.dao.ChoiceDao;
import questionnaire.web.dao.QuestionDao;
import questionnaire.web.dao.QuestionnaireDao;

import java.util.HashSet;

/**
 * 问卷设计业务逻辑的Controller
 */
@Controller
@RequestMapping(value = "/questionnaire/design")
public class QuestionnaireDesignController {
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
     * 访问问卷ID对应的问卷的设计页面
     *
     * @param questionnaireId 问卷ID
     * @param model Model
     * @return 问卷ID对应的问卷的设计页面
     */
    @RequestMapping(value = "/{questionnaireId}", method = RequestMethod.GET)
    public String getDesignPage(@PathVariable("questionnaireId") String questionnaireId, Model model){
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        // 将问卷对象添加到model的属性中
        model.addAttribute("questionnaire", questionnaireTable);

        // 返回问卷设计jsp页面
        return "design";
    }

    /**
     * 修改问卷的标题
     *
     * @param questionnaireId 问卷的ID
     * @param newTitle 问卷的标题
     * @return 问卷设计页面
     */
    @RequestMapping(value = "/modifyTitle.do", method = RequestMethod.POST)
    public String modifyTitle(@RequestParam("questionnaireId") String questionnaireId,
                              @RequestParam("newTitle") String newTitle){
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        // 更新问卷的标题
        questionnaireTable.setTableName(newTitle);
        // 更新问卷信息
        questionnaireDao.updateQuestionnaire(questionnaireTable);

        // 重定向到对应的问卷设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 添加新的问题，可选添加单选题、多选题、填空题
     *
     * @param questionnaireId 添加问题的问卷ID
     * @param addType 添加的问题的类型
     * @return 问卷设计页面
     */
    @RequestMapping(value = "/addQuestion.do", method = RequestMethod.POST)
    public String addQuestion(@RequestParam("questionnaireId") String questionnaireId,
                              @RequestParam("addType") String addType){
        switch (addType) {
            // 添加单选题
            case "radio": {
                // 获取新增单选题的问卷对象
                QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
                QChoose qChoose =
                        new QChoose(null, "新的单选题", false, questionnaireTable,
                                questionnaireTable.getQuestions().size() + 1, new HashSet<>(), false, new HashSet<>());
                // 单选题被新增时,默认包含两个选项
                Choice choice1 = new Choice(null, 1, qChoose, "选项一", null);
                Choice choice2 = new Choice(null, 2, qChoose, "选项二", null);
                qChoose.setQuestionType(false);
                // 添加单选题
                questionDao.createQuestion(qChoose);
                // 添加对应的选项
                choiceDao.addChoice(choice1);
                choiceDao.addChoice(choice2);

                break;
            }
            // 添加多选题
            case "checkbox": {
                // 获取新增多选题的问卷对象
                QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
                QChoose qChoose =
                        new QChoose(null, "新的多选题", false, questionnaireTable,
                                questionnaireTable.getQuestions().size() + 1, null, true, new HashSet<>());
                // 多选题被新增时,默认包含三个选项
                Choice choice1 = new Choice(null, 1, qChoose, "选项一", null);
                Choice choice2 = new Choice(null, 2, qChoose, "选项二", null);
                Choice choice3 = new Choice(null, 3, qChoose, "选项三", null);
                qChoose.setQuestionType(false);
                // 添加多选题
                questionDao.createQuestion(qChoose);
                // 添加对应的选项
                choiceDao.addChoice(choice1);
                choiceDao.addChoice(choice2);
                choiceDao.addChoice(choice3);

                break;
            }
            // 添加填空题
            case "text": {
                // 获取新增填空题的问卷对象
                QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
                QText qText;
                qText = new QText();
                // 设置填空题默认的题目描述
                qText.setDescription("新的填空题");
                qText.setParentTable(questionnaireTable);
                // 设置问题类型为填空题,questionType为true表示填空题,为false表示选择题
                qText.setQuestionType(true);
                qText.setQuestionOrder(questionnaireTable.getQuestions().size() + 1);
                // 添加填空题
                questionDao.createQuestion(qText);

                break;
            }
        }

        // 重定向到问卷的设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 根据问题ID删除某个问题
     *
     * @param questionnaireId 问卷ID
     * @param questionId 问题ID
     * @return 问卷设计页面
     */
    @RequestMapping(value = "/deleteQuestion.do", method = RequestMethod.POST)
    public String deleteQuestion(@RequestParam("questionnaireId") String questionnaireId,
                                 @RequestParam("questionId") String questionId){
        questionDao.deleteQuestion(questionId);

        // 重定向到问卷的设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 根据问题ID修改问题的描述
     *
     * @param questionnaireId 问卷ID
     * @param questionId 问题ID
     * @param newQuestionName 新的问题描述
     * @return 问卷设计页面
     */
    @RequestMapping(value = "/modifyQuestion.do", method = RequestMethod.POST)
    public String modifyQuestion(@RequestParam("questionnaireId") String questionnaireId,
                                 @RequestParam("questionId") String questionId,
                                 @RequestParam("newQuestionName") String newQuestionName){
        QuestionType question = questionDao.readOneQuestion(questionId);
        question.setDescription(newQuestionName);
        questionDao.updateQuestion(question);

        // 重定向到问卷的设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 为单选题或多选题添加新选项
     *
     * @param questionnaireId 问卷ID
     * @param questionId 问题ID
     * @param newChoiceName 新选项的内容
     * @return 问卷设计页面
     */
    @RequestMapping(value = "/addChoice.do", method = RequestMethod.POST)
    public String addChoice(@RequestParam("questionnaireId") String questionnaireId,
                            @RequestParam("questionId") String questionId,
                            @RequestParam("newChoiceName") String newChoiceName){
        QChoose question = (QChoose) questionDao.readOneQuestion(questionId);
        Choice choice = new Choice(null, question.getChoices().size() + 1, question, newChoiceName, new HashSet<>());
        choiceDao.addChoice(choice);

        // 重定向到问卷的设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 根据ID删除问题的选项
     *
     * @param questionnaireId 问卷ID
     * @param choiceId 选项ID
     * @return 问卷设计页面
     */
    @RequestMapping(value = "/deleteChoice.do", method = RequestMethod.POST)
    public String deleteChoice(@RequestParam("questionnaireId") String questionnaireId,
                               @RequestParam("choiceId") String choiceId){
        choiceDao.deleteChoice(choiceId);

        // 重定向到问卷的设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 根据ID修改选项的名称
     *
     * @param choiceId 选项ID
     * @param questionnaireId 问卷ID
     * @param newChoiceName 新的选项名称
     * @return 问卷设计页面
     */
    @RequestMapping(value = "/modifyChoice.do", method = RequestMethod.POST)
    public String modifyChoice(@RequestParam("choiceId") String choiceId,
                               @RequestParam("questionnaireId") String questionnaireId,
                               @RequestParam("newChoiceName") String newChoiceName){
        Choice choice = choiceDao.readOneChoice(choiceId);
        choice.setChoiceContent(newChoiceName);
        choiceDao.updateChoice(choice);

        // 重定向到问卷的设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 访问预览问卷页面
     *
     * @param questionnaireId 问卷ID
     * @param model Model
     * @return 问卷ID对应的问卷的预览页面
     */
    @RequestMapping(value = "/preview/{questionnaireId}", method = RequestMethod.GET)
    public String previewQuestionnaire(@PathVariable("questionnaireId") String questionnaireId, Model model){
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        String  userName=questionnaireTable.getUser().getUserName();
        model.addAttribute("questionnaire", questionnaireTable);
        model.addAttribute("userPreview",userName);

        // 返回问卷预览的jsp页面
        return "questionnaire";
    }

    /**
     * 问卷提交审核
     *
     * @param questionnaireId 问卷ID
     * @return 用户问卷列表首页
     */
    @RequestMapping(value = "/submit.do", method = RequestMethod.POST)
    public String submitQuestionnaire(@RequestParam("questionnaireId") String questionnaireId){
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        // 将问卷提交审核
        questionnaireTable.setIsPublished(true);
        questionnaireDao.updateQuestionnaire(questionnaireTable);

        // 重定向到用户问卷列表首页
        return "redirect:/questionnaire";
    }
}
