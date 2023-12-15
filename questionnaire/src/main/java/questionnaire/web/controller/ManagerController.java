package questionnaire.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import questionnaire.database.CommonUser;
import questionnaire.database.Manager;
import questionnaire.database.QuestionnaireTable;
import questionnaire.web.dao.CommonUserDao;
import questionnaire.web.dao.ManagerDao;
import questionnaire.web.dao.impl.QuestionnaireDaoImpl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by zong chang on 2023/12/11 19:28
 */

@Controller
@RequestMapping("/manager") // manager web path
public class ManagerController {
    @Autowired
    private CommonUserDao commonUserDao;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private QuestionnaireDaoImpl questionnaireDao;
    /**
     * GET manager login page
     *
     * @return manager login page
     */
    @RequestMapping(value = "/login", method = GET)
    public String showManagerLogin() {
        return "loginManager";
    }


    /**
     * POST handle manager login
     *
     * @param userName manager userName
     * @param password manager password
     * @param session  httpsession
     * @return if success redirect to managerAccount.jsp
     */
    @RequestMapping(value = "/login", method = POST)
    public String processManagerLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
                                      @RequestParam(value = "password", defaultValue = "") String password, HttpSession session, Model model) {
        Manager manager = managerDao.verifyManager(userName, password);
        if (manager != null) {
            session.setAttribute("manager", manager);
            return "redirect:/manager/manageManager";
        } else {
            model.addAttribute("err", "1");
            return "loginManager";
        }
    }

    /**
     * GET Manager home page
     *
     * @param model add some necessary model attributes
     * @return managerAccount.jsp
     */
    @RequestMapping(value = "/manageManager", method = GET)
    public String managerAccountManage(Model model, HttpSession session, String userName) {
        if (session.getAttribute("manager") != null && session.getAttribute("manager") instanceof Manager) {
            Manager searchManager = managerDao.findManagerByUserName(userName);
            model.addAttribute("searchManager", searchManager);
            List<Manager> managerList = managerDao.getAllManagers();
            if (managerList != null) {
                model.addAttribute("managerList", managerList);
                return "managerAccount";
            }
        }
        return "redirect:/";
    }

    /**
     * GET Manage commonuser page
     *
     * @param model add common user attributes
     * @return managerUser.jsp
     */
    @RequestMapping(value = "/manageUser", method = GET)
    public String userAccountManage(Model model, String userName, HttpSession session) {
        if (session.getAttribute("manager") != null && session.getAttribute("manager") instanceof Manager) {
            model.addAttribute("searchCommonUser", userName);
            List<CommonUser> commonUserList = commonUserDao.getAllCommonUsers();
            model.addAttribute("commonUserList", commonUserList);
            return "managerUser";
        }
        return "redirect:/";
    }

    /**
     * GET Manage Questionnaire page
     *
     * @param model add questionnaireTable attributes
     * @return managerQuestionnaire.jsp
     */
    @RequestMapping(value = "/manageQuestionnaire", method = GET)
    public String questionnaireManage(Model model, HttpSession session) {
        if (session.getAttribute("manager") != null && session.getAttribute("manager") instanceof Manager) {
            List<QuestionnaireTable> allUncheckedQuestionnaires = questionnaireDao.readAllUncheckedQuestionnaires();
            List<QuestionnaireTable> uncheckedAndIsPublishedQues = new ArrayList<>();
            for (QuestionnaireTable questionnaire : allUncheckedQuestionnaires) {
                if (questionnaire.getIsPublished()) {
                    uncheckedAndIsPublishedQues.add(questionnaire);
                }
            }
            model.addAttribute("uncheckedQuestionnaires", uncheckedAndIsPublishedQues);
            return "managerQuestionnaire";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/preview/{questionnaireId}", method = RequestMethod.GET)
    public String previewQuestionnaire(@PathVariable("questionnaireId") String questionnaireId, Model model){
        QuestionnaireTable questionnaireTable = questionnaireDao.getOneQuestionnaire(questionnaireId);
        model.addAttribute("questionnaire", questionnaireTable);
        return "questionnaire";
    }

    /**
     * GET view manager info by userName
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/managerinfo/{userName}", method = GET)
    public String showManagerInfo(@PathVariable String userName, Model model) {
        Manager manager = managerDao.findManagerByUserName(userName);
        if (manager != null) {
            model.addAttribute("managerinfo", manager);
        }
        return "viewManagerInfo";
    }

    /**
     * GET view commonuser info by userName
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/commonuserinfo/{userName}", method = GET)
    public String showCommonUserInfo(@PathVariable String userName, Model model) {
        CommonUser commonUser = commonUserDao.readOneUser(userName);
        if (commonUser != null) {
            model.addAttribute("commonUser", commonUser);
        }
        return "viewOther";
    }


    /**
     * GET show commonuser info change page
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/changeuserinfo/{userName}", method = GET)
    public String showChangeCommonUserInfo(@PathVariable String userName, Model model,String duplicateName) {
        CommonUser commonUser = commonUserDao.readOneUser(userName);
        if (commonUser != null) {
            model.addAttribute("info", commonUser);
            model.addAttribute("duplicateName",duplicateName);
        }
        return "changeInfo";
    }

    /**
     * GET show commonuser info change page
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/changeManagerinfo/{userName}", method = GET)
    public String showChangeManagerInfo(@PathVariable String userName, Model model,String duplicateName ) {
        Manager manager = managerDao.findManagerByUserName(userName);
        if (manager != null) {
            model.addAttribute("info", manager);
            model.addAttribute("duplicateName",duplicateName);
        }
        return "changeInfo";
    }

    /**
     * POST change manager info by the following attributes
     * todo:There's a huge problem with the interface here,cannot use so many params
     *
     * @param lastName
     * @param firstName
     * @param userName
     * @param password
     * @param pho
     * @param email
     * @param oldName
     * @param model
     * @return
     */
    @RequestMapping(value = "/changeManagerinfo/{userName}", method = POST)
    public String changeManagerInfo(
            @RequestParam(value = "lastName", defaultValue = "") String lastName,
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "userName", defaultValue = "") String userName,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "pho", defaultValue = "") String pho,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "oldName",defaultValue = "") String  oldName,
            Model model) {
        if(!userName.equals("admin")) {
            if(managerDao.findManagerByUserName(userName) != null){
                model.addAttribute("duplicateName", userName);
                return "redirect:/manager/changeManagerinfo/"+oldName;
            }
            Manager oldManager = managerDao.findManagerByUserName(oldName);
            oldManager.setFirstName(firstName);
            oldManager.setLastName(lastName);
            oldManager.setUserName(userName);
            oldManager.setPassword(password);
            oldManager.setPhoneNo(pho);
            oldManager.setEmail(email);
            managerDao.updateOneManager(oldManager);
        }
        return "redirect:/manager/manageManager";
    }


    /**
     * POST change common user info
     * todo:just like above
     *
     * @param lastName
     * @param firstName
     * @param userName
     * @param password
     * @param pho
     * @param email
     * @param oldName
     * @param model
     * @return
     */
    @RequestMapping(value = "/changeuserinfo/{userName}", method = POST)
    public String changeCommonUserInfo(
            @RequestParam(value = "lastName", defaultValue = "") String lastName,
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "userName", defaultValue = "") String userName,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "pho", defaultValue = "") String pho,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "oldName", defaultValue = "") String oldName,
            Model model) {
        if(commonUserDao.readOneUser(userName) != null){
            model.addAttribute("duplicateName", userName);
            return "redirect:/manager/changeuserinfo/"+oldName;
        }
        CommonUser oldCommonUser = commonUserDao.readOneUser(oldName);
        oldCommonUser.setFirstName(firstName);
        oldCommonUser.setLastName(lastName);
        oldCommonUser.setUserName(userName);
        oldCommonUser.setPassword(password);
        oldCommonUser.setPhoneNo(pho);
        oldCommonUser.setEmail(email);
        commonUserDao.updateOneUser(oldCommonUser);
        return "redirect:/manager/manageUser";
    }


    /**
     * POST check the questionnaireTable by tableId
     *
     * @param tableId
     * @return
     */
    @RequestMapping(value = "/checkQue.do", method = POST)
    public String checkQuestionnaire(@RequestParam(value = "tableId", defaultValue = "") String tableId, @RequestParam(value = "check", defaultValue = "-1") String check) {
        QuestionnaireTable uncheckTable = questionnaireDao.getOneQuestionnaire(tableId);

        if (check.equals("1")) {
            if (!uncheckTable.getIsChecked() && uncheckTable.getIsPublished()) {
                uncheckTable.setIsChecked(true);
            }
            questionnaireDao.updateQuestionnaire(uncheckTable);
        } else {
            uncheckTable.setIsPublished(false);
            questionnaireDao.updateQuestionnaire(uncheckTable);
        }
        return "redirect:/manager/manageQuestionnaire";
    }


    /**
     * GET show add page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add.do", method = GET)
    public String addManager(Model model,String duplicateName) {
        model.addAttribute("duplicateName",duplicateName);
        return "addManager";
    }

    /**
     * GET handle logout
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout.do", method = GET)
    public String logOut(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    /**
     * POST add a valid manager
     *
     * @param manager
     * @param errors
     * @param model
     * @return
     */
    @RequestMapping(value = "/add.do", method = POST)
    public String processAddManager(@Valid Manager manager, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "/manager/add.do";
        }
        if(managerDao.findManagerByUserName(manager.getUserName()) != null){
            model.addAttribute("duplicateName", manager.getUserName());
            return "redirect:/manager/add.do";
        }
        Manager newmanager = managerDao.addManager(manager);
        return "redirect:/manager/manageManager";
    }

    /**
     *POST delete a manager by id
     *
     * @param managerId
     * @param session
     * @return
     */
    @RequestMapping(value = "/delete.do", method = POST)
    public String processDeleteManager(@RequestParam(value = "managerId", defaultValue = "") String managerId,
                                       HttpSession session) {
        managerDao.deleteManager(managerId);
        return "redirect:/manager/manageManager";
    }

    /**
     * POST search a manager by userName
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchManager.do", method = POST)
    public String processSearchManager(@RequestParam(value = "userName", defaultValue = "") String userName,
                                       Model model) {
        System.out.println(userName);
        Manager searchManager = managerDao.findManagerByUserName(userName);
        if (searchManager != null) {
            model.addAttribute("userName", searchManager.getUserName());
        }
        return "redirect:/manager/manageManager";
    }

    /**
     * POST search a commonuser by userName
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchCommonUser.do", method = POST)
    public String processSearchCommonUser(@RequestParam(value = "userName", defaultValue = "") String userName,
                                          Model model) {
        System.out.println(userName);
        CommonUser searchCommonUser = commonUserDao.readOneUser(userName);
        if (searchCommonUser != null) {
            model.addAttribute("userName", searchCommonUser.getUserName());
        }
        return "redirect:/manager/manageUser";
    }

}
