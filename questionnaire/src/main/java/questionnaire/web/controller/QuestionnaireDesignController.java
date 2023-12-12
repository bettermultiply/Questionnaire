package questionnaire.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import questionnaire.database.*;
import questionnaire.web.dao.QuestionDao;
import questionnaire.web.dao.impl.QuestionnaireDaoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping(value = "/questionnaire/design")
public class QuestionnaireDesignController {
    @Autowired
    private QuestionnaireDaoImpl questionnaireDao;
    @Autowired
    private QuestionDao questionDao;

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
                QChoose qChoose = new QChoose(null, "新的单选题", false,questionnaireTable, null, null, false, new HashSet<>());
                Choice choice1 = new Choice(null, 1, qChoose, "选项一", null);
                Choice choice2 = new Choice(null, 2, qChoose, "选项二", null);
                qChoose.getChoices().add(choice1);
                qChoose.getChoices().add(choice2);
                qChoose.setQuestionType(false);
                questionDao.createQuestion(qChoose);
                questionnaireTable.getQuestions().add(qChoose);
                questionnaireDao.updateQuestionnaire(questionnaireTable);
                break;
            }
            case "checkbox": {
                QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
                QChoose qChoose = new QChoose(null, "新的多选题", false, questionnaireTable, null, null, true, new HashSet<>());
                Choice choice1 = new Choice(null, 1, qChoose, "选项一", null);
                Choice choice2 = new Choice(null, 2, qChoose, "选项二", null);
                Choice choice3 = new Choice(null, 3, qChoose, "选项三", null);
                qChoose.getChoices().add(choice1);
                qChoose.getChoices().add(choice2);
                qChoose.getChoices().add(choice3);
                qChoose.setQuestionType(false);
                questionDao.createQuestion(qChoose);
                questionnaireTable.getQuestions().add(qChoose);
                questionnaireDao.updateQuestionnaire(questionnaireTable);
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
                questionnaireTable.getQuestions().add(qText);
                questionnaireDao.updateQuestionnaire(questionnaireTable);
                break;
            }
        }

        return "redirect:/questionnaire/design/" + questionnaireId;
    }
}
