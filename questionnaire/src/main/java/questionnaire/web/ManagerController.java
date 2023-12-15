package questionnaire.web;

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
import questionnaire.utils.CommonUserTools;
import questionnaire.utils.ManagerTools;
import questionnaire.utils.QuestionnaireTools;
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
                                      @RequestParam(value = "password", defaultValue = "") String password, HttpSession session) {
        Manager manager = ManagerTools.verifyManager(userName, password);
        if (manager != null) {
            session.setAttribute("manager", manager);
            return "redirect:/manager/manageManager";
        } else {
            return "redirect:/manager/login";
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
            Manager searchManager = ManagerTools.findManagerByUserName(userName);
            model.addAttribute("searchManager", searchManager);
            List<Manager> managerList = ManagerTools.getAllManagers();
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
            List<CommonUser> commonUserList = CommonUserTools.getAllCommonUsers();
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
            List<QuestionnaireTable> allUncheckedQuestionnaires = QuestionnaireTools.readAllUncheckedQuestionnaires();
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
        Manager manager = ManagerTools.findManagerByUserName(userName);
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
        CommonUser commonUser = CommonUserTools.readOneUser(userName);
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
    public String showChangeCommonUserInfo(@PathVariable String userName, Model model) {
        CommonUser commonUser = CommonUserTools.readOneUser(userName);
        if (commonUser != null) {
            model.addAttribute("User", commonUser);
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
    public String showChangeManagerInfo(@PathVariable String userName, Model model) {
        Manager manager = ManagerTools.findManagerByUserName(userName);
        if (manager != null) {
            model.addAttribute("User", manager);
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
        if(!oldName.equals("admin")) {
            Manager oldManager = ManagerTools.findManagerByUserName(oldName);
            oldManager.setFirstName(firstName);
            oldManager.setLastName(lastName);
            oldManager.setUserName(userName);
            oldManager.setPassword(password);
            oldManager.setPhoneNo(pho);
            oldManager.setEmail(email);
            ManagerTools.updateOneManager(oldManager);
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
        CommonUser oldCommonUser = CommonUserTools.readOneUser(oldName);
        oldCommonUser.setFirstName(firstName);
        oldCommonUser.setLastName(lastName);
        oldCommonUser.setUserName(userName);
        oldCommonUser.setPassword(password);
        oldCommonUser.setPhoneNo(pho);
        oldCommonUser.setEmail(email);
        CommonUserTools.updateOneUser(oldCommonUser);
        return "redirect:/manager/manageUser";
    }


    /**
     * POST check the questionnaireTable by tableId
     *
     * @param tableId
     * @return
     */
    @RequestMapping(value = "/checkQue.do", method = POST)
    public String checkQuestionnaire(@RequestParam(value = "tableId", defaultValue = "") String tableId) {
        if (!tableId.equals("-1")) {
            QuestionnaireTable uncheckTable = QuestionnaireTools.readOneQuestionnaire(tableId);
            if (!uncheckTable.getIsChecked() && uncheckTable.getIsPublished()) {
                uncheckTable.setIsChecked(true);
            }
            QuestionnaireTools.updateQuestionnaire(uncheckTable);
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
        if(ManagerTools.findManagerByUserName(manager.getUserName()) != null){
            model.addAttribute("duplicateName", manager.getUserName());
            return "redirect:/manager/add.do";
        }
        Manager newmanager = ManagerTools.addManager(manager);
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
        ManagerTools.deleteManager(managerId);
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
        Manager searchManager = ManagerTools.findManagerByUserName(userName);
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
        CommonUser searchCommonUser = CommonUserTools.readOneUser(userName);
        if (searchCommonUser != null) {
            model.addAttribute("userName", searchCommonUser.getUserName());
        }
        return "redirect:/manager/manageUser";
    }

}
