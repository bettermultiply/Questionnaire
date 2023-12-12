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
import questionnaire.web.dao.impl.QuestionnaireDaoImpl;

import java.util.HashSet;

@Controller
@RequestMapping(value = "/questionnaire/design")
public class QuestionnaireDesignController {
    @Autowired
    private QuestionnaireDaoImpl questionnaireDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private ChoiceDao choiceDao;

    @RequestMapping(value = "/{questionnaireId}", method = RequestMethod.GET)
    public String getDesignPage(@PathVariable("questionnaireId") String questionnaireId, Model model){
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        model.addAttribute("questionnaire", questionnaireTable);

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
        questionnaireTable.setTableName(newTitle);
        questionnaireDao.updateQuestionnaire(questionnaireTable);

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
            case "radio": {
                QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
                QChoose qChoose = new QChoose(null, "新的单选题", false,questionnaireTable, null, false, new HashSet<>());
                Choice choice1 = new Choice(null, 1, qChoose, "选项一", null);
                Choice choice2 = new Choice(null, 2, qChoose, "选项二", null);
                qChoose.setQuestionType(false);
                questionDao.createQuestion(qChoose);
                choiceDao.addChoice(choice1);
                choiceDao.addChoice(choice2);

                break;
            }
            case "checkbox": {
                QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
                QChoose qChoose = new QChoose(null, "新的多选题", false, questionnaireTable, null, true, new HashSet<>());
                Choice choice1 = new Choice(null, 1, qChoose, "选项一", null);
                Choice choice2 = new Choice(null, 2, qChoose, "选项二", null);
                Choice choice3 = new Choice(null, 3, qChoose, "选项三", null);
                qChoose.setQuestionType(false);
                questionDao.createQuestion(qChoose);
                choiceDao.addChoice(choice1);
                choiceDao.addChoice(choice2);
                choiceDao.addChoice(choice3);

                break;
            }
            case "text": {
                QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
                QText qText;
                qText = new QText();
                qText.setDescription("新的填空题");
                qText.setParentTable(questionnaireTable);
                qText.setQuestionType(true);
                questionDao.createQuestion(qText);

                break;
            }
        }

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
        question.getChoices().add(choice);
        choiceDao.addChoice(choice);

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

        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    @RequestMapping(value = "/modifyChoice.do", method = RequestMethod.POST)
    public String modifyChoice(@RequestParam("choiceId") String choiceId,
                               @RequestParam("questionnaireId") String questionnaireId,
                               @RequestParam("newChoiceName") String newChoiceName){
        Choice choice = choiceDao.readOneChoice(choiceId);
        choice.setChoiceContent(newChoiceName);
        choiceDao.updateChoice(choice);

        return "redirect:/questionnaire/design/" + questionnaireId;
    }
}
