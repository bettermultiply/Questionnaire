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
import questionnaire.web.dao.QuestionDao;
import questionnaire.web.dao.QuestionnaireDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 用户问卷列表相关的业务逻辑的Controller
 */
@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireManageController {
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
     * 获取默认问卷页面
     *
     * @param session HttpSession
     * @param model   Model
     * @return 问卷列表的JSP页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getQuestionnairePage(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) {
        int page = 0;
        CommonUser commonUser = ((CommonUser) session.getAttribute("commonUser"));
        //初次登录，添加用户cookie到浏览器，实现后续访问的自动登录
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if (!"userName".equals(cookieName)) {
                Cookie userCookie = new Cookie("userName", commonUser.getUserName());
                cookie.setMaxAge(-1);
                response.addCookie(userCookie);
            }
        }
        String userId = commonUser.getUserId();
        // 获取该用户的所有问卷
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getAllQuestionnaires(userId);
        // 计算问卷列表的总页数
        int totalPage = questionnaireTables.size() / 8;
        model.addAttribute("type", "all"); // 设置该页面显示所有问卷
        // 将当前页的问卷列表设置为该页面的属性
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(0,
                Math.min(questionnaireTables.size(), 8)));
        // 总页数
        model.addAttribute("totalPage", totalPage);
        // 当前页数
        model.addAttribute("currentPage", page);

        // 返回用户首页jsp页面
        return "userHome";
    }

    /**
     * 访问用户基本信息页面
     *
     * @return 用户基本信息页面
     */
    @RequestMapping(value = "/info", method = GET) // 相应的请求方法
    public String showCommonUserInfo() {
        return "viewUserSelf";
    }

    /**
     * 获取某一页的问卷页面
     *
     * @param session HttpSession
     * @param model   Model
     * @return 问卷列表的JSP页面
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String getQuestionnairePage(@PathVariable("page") Integer page, HttpSession session, Model model) {
        String userId = ((CommonUser) session.getAttribute("commonUser")).getUserId();
        // 获取该用户的所有问卷
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getAllQuestionnaires(userId);
        // 计算问卷列表的总页数
        int totalPage = questionnaireTables.size() / 8;
        int beginItem = 8 * page;
        int endItem = beginItem + 8;
        model.addAttribute("type", "all"); // 设置该页面显示所有问卷
        // 将当前页的问卷列表设置为该页面的属性
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(beginItem,
                Math.min(endItem, questionnaireTables.size())));
        // 总页数
        model.addAttribute("totalPage", totalPage);
        // 当前页
        model.addAttribute("currentPage", page);

        // 返回用户首页jsp页面
        return "userHome";
    }

    /**
     * 访问数据统计页面
     *
     * @param tableId 问卷ID
     * @param tableName 问卷标题
     * @param model Model
     * @return 问卷数据统计页面
     */
    @RequestMapping(value = "/statistics.do", method = RequestMethod.POST)
    public String getStaticsPage(@RequestParam("questionnaireId") String tableId, @RequestParam("questionnaireName") String tableName, Model model) {
        // 问卷的问题列表
        List<QuestionType> questions = questionDao.readQuestion(tableId);
        // 将问题列表设置为该页面的属性
        model.addAttribute("questions", questions);
        // 将问卷名称设为该页面的属性
        model.addAttribute("tableName", tableName);

        // 返回问卷的数据统计页面
        return "statistics";
    }

    /**
     * 删除单个问卷
     *
     * @param questionnaireId 被删除的问卷ID
     * @return 问卷列表的JSP页面
     */
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public String deleteQuestionnaire(@RequestParam("questionnaireId") String questionnaireId) {
        questionnaireDao.deleteQuestionnaire(questionnaireId);

        // 重定向到用户问卷首页
        return "redirect:/questionnaire";
    }

    /**
     * 修改单个问卷
     *
     * @param questionnaireId 被修改的问卷ID
     * @return 该问卷的设计页面
     */
    @RequestMapping(value = "/modify.do", method = RequestMethod.POST)
    public String modifyQuestionnaire(@RequestParam("questionnaireId") String questionnaireId) {
        // 重定向到问卷修改页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 添加新问卷
     *
     * @param tableName 新问卷的名称
     * @param session   HttpSession
     * @return 重定向到新问卷的设计页面
     */
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addQuestionnaire(@RequestParam("tableName") String tableName, HttpSession session) {
        String questionnaireId;
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        QuestionnaireTable questionnaireTable =
                new QuestionnaireTable(null, tableName, false, false, commonUser, new HashSet<>(), new HashSet<>());
        commonUser.getQuestionnaireTables().add(questionnaireTable);
        // 新建问卷
        questionnaireId = questionnaireDao.addQuestionnaire(questionnaireTable);

        // 重定向新建问卷的设计页面
        return "redirect:/questionnaire/design/" + questionnaireId;
    }

    /**
     * 获取用户所有已审核的问卷
     *
     * @param session HttpSession
     * @param model   Model
     * @return 用户所有已审核问卷的页面
     */
    @RequestMapping(value = "/checked", method = RequestMethod.GET)
    public String getCheckedQuestionnairePage(HttpSession session, Model model) {
        int page = 0;
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        // 获取该用户所有已审核的问卷列表
        ArrayList<QuestionnaireTable> questionnaireTables =
                (ArrayList<QuestionnaireTable>) questionnaireDao.getCheckedQuestionnaire(commonUser.getUserId());
        // 计算问卷列表的总页数
        int totalPage = questionnaireTables.size() / 8;
        model.addAttribute("type", "checked"); // 设置该页面显示所有已审核的问卷
        // 将当前页的问卷列表设置为页面的属性
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(0,
                Math.min(questionnaireTables.size(), 8)));
        // 总页数
        model.addAttribute("totalPage", totalPage);
        // 当前页
        model.addAttribute("currentPage", page);

        // 返回用户问卷列表首页
        return "userHome";
    }

    /**
     * 获取用户所有已审核的问卷分页
     *
     * @param session HttpSession
     * @param model   Model
     * @return 用户所有已审核问卷分页的分页
     */
    @RequestMapping(value = "/checked/{page}", method = RequestMethod.GET)
    public String getCheckedQuestionnairePage(@PathVariable("page") Integer page, HttpSession session, Model model) {
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        // 获取该用户所有已审核的问卷列表
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getCheckedQuestionnaire(commonUser.getUserId());
        // 计算问卷列表的总页数
        int totalPage = questionnaireTables.size() / 8;
        int beginItem = 8 * page;
        int endItem = beginItem + 8;
        model.addAttribute("type", "checked"); // 设置该页面显示所有问卷
        // 将当前页的问卷列表设置为页面的属性
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(beginItem,
                Math.min(endItem, questionnaireTables.size())));
        // 总页数
        model.addAttribute("totalPage", totalPage);
        // 当前页
        model.addAttribute("currentPage", page);

        // 返回用户问卷列表首页
        return "userHome";
    }

    /**
     * 获取用户所有未审核的问卷
     *
     * @param session HttpSession
     * @param model   Model
     * @return 用户所有已审核问卷的页面
     */
    @RequestMapping(value = "/unchecked", method = RequestMethod.GET)
    public String getUncheckedQuestionnairePage(HttpSession session, Model model) {
        int page = 0;
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        // 获取用户所有未审核的问卷列表
        ArrayList<QuestionnaireTable> questionnaireTables =
                (ArrayList<QuestionnaireTable>) questionnaireDao.getUncheckedQuestionnaire(commonUser.getUserId());
        // 计算问卷列表的总页数
        int totalPage = questionnaireTables.size() / 8;
        model.addAttribute("type", "unchecked"); // 设置该页面显示所有未审核的问卷
        // 将当前页的问卷列表设置为页面的属性
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(0,
                Math.min(questionnaireTables.size(), 8)));
        // 总页数
        model.addAttribute("totalPage", totalPage);
        // 当前页
        model.addAttribute("currentPage", page);

        // 返回用户问卷列表首页
        return "userHome";
    }

    /**
     * 获取用户所有未审核的问卷分页
     *
     * @param session HttpSession
     * @param model   Model
     * @return 用户所有已审核问卷的分页
     */
    @RequestMapping(value = "/unchecked/{page}", method = RequestMethod.GET)
    public String getUncheckedQuestionnairePage(@PathVariable("page") Integer page, HttpSession session, Model model) {
        CommonUser commonUser = (CommonUser) session.getAttribute("commonUser");
        // 该用户所有未审核的问卷列表
        ArrayList<QuestionnaireTable> questionnaireTables = (ArrayList<QuestionnaireTable>)
                questionnaireDao.getUncheckedQuestionnaire(commonUser.getUserId());
        // 计算问卷列表的总页数
        int totalPage = questionnaireTables.size() / 8;
        int beginItem = 8 * page;
        int endItem = beginItem + 8;
        model.addAttribute("type", "unchecked"); // 设置该页面显示所有问卷
        // 将当前页的问卷列表设置为页面的属性
        model.addAttribute("allQuestionnaire", questionnaireTables.subList(beginItem,
                Math.min(endItem, questionnaireTables.size())));
        // 总页数
        model.addAttribute("totalPage", totalPage);
        // 当前页
        model.addAttribute("currentPage", page);

        // 返回用户问卷列表首页
        return "userHome";
    }
}
