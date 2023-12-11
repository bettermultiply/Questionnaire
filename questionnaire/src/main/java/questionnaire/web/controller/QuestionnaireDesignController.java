package questionnaire.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.database.QuestionType;
import questionnaire.database.QuestionnaireTable;
import questionnaire.web.dao.QuestionDao;
import questionnaire.web.dao.impl.QuestionnaireDaoImpl;

import java.util.ArrayList;

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
        String title = questionnaireTable.getTableName();
        ArrayList<QuestionType> questionTypes = (ArrayList<QuestionType>) questionDao.readQuestion(questionnaireId);
        model.addAttribute("title", title);
        model.addAttribute("questionTypes", questionTypes);

        return "design";
    }
}
