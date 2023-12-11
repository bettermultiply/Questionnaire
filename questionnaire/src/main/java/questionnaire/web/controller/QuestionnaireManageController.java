package questionnaire.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import questionnaire.database.CommonUser;
import questionnaire.database.QuestionnaireTable;
import questionnaire.web.dao.QuestionnaireDao;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireManageController {
    /**
     * 问卷Dao
     */
    @Autowired
    private QuestionnaireDao questionnaireDao;

    /**
     * 获取默认问卷页面
     *
     * @param session HttpSession
     * @param model Model
     * @return 问卷列表的JSP页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getQuestionnairePage(HttpSession session, Model model){
        int page = 0;
        String userId = ((CommonUser)session.getAttribute("commonUser")).getUserId();
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getAllQuestionnaires(userId);
        int totalPage = questionnaireTables.size() / 8;
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(0,
                Math.min(questionnaireTables.size(), 8)));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }

    /**
     * 获取某一页的问卷页面
     *
     * @param session HttpSession
     * @param model Model
     * @return 问卷列表的JSP页面
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String getQuestionnairePage(@PathVariable("page") Integer page, HttpSession session, Model model){
        String userId = ((CommonUser)session.getAttribute("commonUser")).getUserId();
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getAllQuestionnaires(userId);
        int totalPage = questionnaireTables.size() / 8;
        int beginItem = 8 * page;
        int endItem = beginItem + 8;
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(beginItem,
                Math.min(endItem, questionnaireTables.size())));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }

    @RequestMapping(value = "/statistics.d", method = RequestMethod.GET)
    public String getStaticsPage(@RequestParam(value = "pageId", required = true) String pageId, HttpSession session){



        return "statistics";
    }

    /**
     * 删除单个问卷
     *
     * @param questionnaireId 被删除的问卷ID
     * @return 问卷列表的JSP页面
     */
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public String deleteQuestionnaire(@RequestParam("questionnaireId") String questionnaireId){
        questionnaireDao.deleteQuestionnaire(questionnaireId);

        return "userHome";
    }

    /**
     * 修改单个问卷
     *
     * @param questionnaireId 被修改的问卷ID
     * @return 该问卷的设计页面
     */
    @RequestMapping(value = "/modify.do", method = RequestMethod.POST)
    public String modifyQuestionnaire(@RequestParam("questionnaireId") String questionnaireId){
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 添加新问卷
     *
     * @param tableName 新问卷的名称
     * @param session HttpSession
     * @return 重定向到新问卷的设计页面
     */
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addQuestionnaire(@RequestParam("tableName") String tableName, HttpSession session){
        String questionnaireId;
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        QuestionnaireTable questionnaireTable = new QuestionnaireTable(null, tableName, false, false, commonUser, null, null);
        questionnaireId = questionnaireDao.addQuestionnaire(questionnaireTable);

        return "redirect:/questionnaire/design/" + questionnaireId;
    }
}
