package questionnaire.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import questionnaire.database.CommonUser;
import questionnaire.database.QuestionType;
import questionnaire.database.QuestionnaireTable;
import questionnaire.utils.CommonUserTools;
import questionnaire.utils.QuestionTools;
import questionnaire.web.dao.QuestionnaireDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
    public String getQuestionnairePage(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) {
           int page = 0;
            CommonUser commonUser=((CommonUser) session.getAttribute("commonUser"));
            //初次登录，添加用户cookie到浏览器，实现后续访问的自动登录
            Cookie [] cookies=request.getCookies();
                for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (!"userName".equals(cookieName)) {
                    Cookie userCookie=new Cookie("userName",commonUser.getUserName());
                    cookie.setMaxAge(-1);
                    response.addCookie(userCookie);
                }
            }
        String  userId = commonUser.getUserId();
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getAllQuestionnaires(userId);
        int totalPage = questionnaireTables.size() / 8;
        model.addAttribute("type", "all"); // 设置该页面显示所有问卷
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(0,
                Math.min(questionnaireTables.size(), 8)));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }

    @RequestMapping(value ="/info",method = GET) // 相应的请求方法
    public String showCommonUserInfo(){
        return "viewUserSelf";
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
        model.addAttribute("type", "all"); // 设置该页面显示所有问卷
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(beginItem,
                Math.min(endItem, questionnaireTables.size())));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }

    @RequestMapping(value = "/statistics.do", method = RequestMethod.POST)
    public String getStaticsPage(@RequestParam("questionnaireId") String tableId, @RequestParam("questionnaireName") String tableName, Model model){

        List<QuestionType> questions = QuestionTools.readQuestion(tableId);
        model.addAttribute("questions", questions);
        model.addAttribute("tableName", tableName);

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

        return "redirect:/questionnaire";
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
        QuestionnaireTable questionnaireTable =
                new QuestionnaireTable(null, tableName, false, false, commonUser, new HashSet<>(), new HashSet<>());
        commonUser.getQuestionnaireTables().add(questionnaireTable);
        questionnaireId = questionnaireDao.addQuestionnaire(questionnaireTable);

        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 获取用户所有已审核的问卷
     *
     * @param session HttpSession
     * @param model Model
     * @return 用户所有已审核问卷的页面
     */
    @RequestMapping(value = "/checked", method = RequestMethod.GET)
    public String getCheckedQuestionnairePage(HttpSession session, Model model){
        int page = 0;
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        ArrayList<QuestionnaireTable> questionnaireTables =
                (ArrayList<QuestionnaireTable>) questionnaireDao.getCheckedQuestionnaire(commonUser.getUserId());
        int totalPage = questionnaireTables.size() / 8;
        model.addAttribute("type", "checked"); // 设置该页面显示所有已审核的问卷
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(0,
                Math.min(questionnaireTables.size(), 8)));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }

    /**
     * 获取用户所有已审核的问卷分页
     *
     * @param session HttpSession
     * @param model Model
     * @return 用户所有已审核问卷分页的分页
     */
    @RequestMapping(value = "/checked/{page}", method = RequestMethod.GET)
    public String getCheckedQuestionnairePage(@PathVariable("page") Integer page, HttpSession session, Model model){
        CommonUser commonUser = (CommonUser)session.getAttribute("commonUser");
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getCheckedQuestionnaire(commonUser.getUserId());
        int totalPage = questionnaireTables.size() / 8;
        int beginItem = 8 * page;
        int endItem = beginItem + 8;
        model.addAttribute("type", "checked"); // 设置该页面显示所有问卷
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(beginItem,
                Math.min(endItem, questionnaireTables.size())));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }

    /**
     * 获取用户所有未审核的问卷
     *
     * @param session HttpSession
     * @param model Model
     * @return 用户所有已审核问卷的页面
     */
    @RequestMapping(value = "/unchecked", method = RequestMethod.GET)
    public String getUncheckedQuestionnairePage(HttpSession session, Model model){
        int page = 0;
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        ArrayList<QuestionnaireTable> questionnaireTables =
                (ArrayList<QuestionnaireTable>) questionnaireDao.getUncheckedQuestionnaire(commonUser.getUserId());
        int totalPage = questionnaireTables.size() / 8;
        model.addAttribute("type", "unchecked"); // 设置该页面显示所有未审核的问卷
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(0,
                Math.min(questionnaireTables.size(), 8)));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }

    /**
     * 获取用户所有未审核的问卷分页
     *
     * @param session HttpSession
     * @param model Model
     * @return 用户所有已审核问卷的分页
     */
    @RequestMapping(value = "/unchecked/{page}", method = RequestMethod.GET)
    public String getUncheckedQuestionnairePage(@PathVariable("page") Integer page, HttpSession session, Model model){
        CommonUser commonUser = (CommonUser)session.getAttribute("commonUser");
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getUncheckedQuestionnaire(commonUser.getUserId());
        int totalPage = questionnaireTables.size() / 8;
        int beginItem = 8 * page;
        int endItem = beginItem + 8;
        model.addAttribute("type", "unchecked"); // 设置该页面显示所有问卷
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(beginItem,
                Math.min(endItem, questionnaireTables.size())));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "userHome";
    }
}
