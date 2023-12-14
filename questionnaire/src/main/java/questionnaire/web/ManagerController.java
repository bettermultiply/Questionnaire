package questionnaire.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import questionnaire.database.CommonUser;
import questionnaire.database.Manager;
import questionnaire.utils.CommonUserTools;
import questionnaire.utils.ManagerTools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by zong chang on 2023/12/11 19:28
 */

@Controller // 控制定义
@RequestMapping("/manager") // 相应web路径
public class ManagerController {

    @RequestMapping(value ="/login",method = GET) // 相应的请求方法
    public String showManagerLogin(Model model){
        return "loginManager";
    }


    @RequestMapping(value ="/login",method = POST) // 相应的请求方法
    public String processManagerLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
                                      @RequestParam(value = "password", defaultValue = "") String password, HttpSession session){
        Manager manager = ManagerTools.verifyManager(userName, password);
        if(manager != null ){
            session.setAttribute("manager",manager);
            return "redirect:/manager/manageManager";
        }else {
            return "redirect:/manager/login";
        }
    }

    /**
     * 管理员信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/manageManager", method = GET)
    public String managerAccountManage(Model model, HttpSession session,String userName) {
        //System.out.println(userName);
        if(session.getAttribute("manager")  !=null&&session.getAttribute("manager")  instanceof Manager){
            Manager searchManager=ManagerTools.findManagerByUserName(userName);
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
     * 管理员信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/manageUser", method = GET)
    public String userAccountManage(Model model,String userName,HttpSession session) {
        //System.out.println(userName);
        if(session.getAttribute("manager")  !=null&&session.getAttribute("manager")  instanceof Manager){
        model.addAttribute("searchCommonUser", userName);
        List<CommonUser> commonUserList=CommonUserTools.getAllCommonUsers();
        model.addAttribute("commonUserList", commonUserList);
        return "managerUser";
        }
            return "redirect:/";
    }

    /**
     * 管理员信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/manageQuestionnaire", method = GET)
    public String questionnaireManage(Model model,HttpSession session) {
        if(session.getAttribute("manager")  !=null&&session.getAttribute("manager")  instanceof Manager) {
            return "managerQuestionnaire";
        }
        return "redirect:/";
    }

    @RequestMapping(value ="/managerinfo/{userName}",method = GET) // 相应的请求方法
    public String showManagerInfo(@PathVariable String userName,Model model){
        Manager manager = ManagerTools.findManagerByUserName(userName);
        if(manager!=null){
            model.addAttribute("managerinfo",manager);
        }
        return "viewManagerInfo";
    }

    @RequestMapping(value ="/commonuserinfo/{userName}",method = GET) // 相应的请求方法
    public String showCommonUserInfo(@PathVariable String userName,Model model){
        CommonUser commonUser = CommonUserTools.readOneUser(userName);
        if(commonUser!=null){
            model.addAttribute("commonUser",commonUser);
        }
        return "viewOther";
    }

    @RequestMapping(value ="/changeuserinfo/{userName}",method = GET) // 相应的请求方法
    public String showChangeCommonUserInfo(@PathVariable String userName,Model model){
        CommonUser commonUser = CommonUserTools.readOneUser(userName);
        if(commonUser!=null){
            model.addAttribute("commonUser",commonUser);
        }
        return "changeInfo";
    }

    @RequestMapping(value ="/manageManager",method = POST) // 相应的请求方法
    public String changeManagerInfo(
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName,
                                       @RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "username", defaultValue = "") String userName,
                                       @RequestParam(value = "password", defaultValue = "") String password,
                                       @RequestParam(value = "pho", defaultValue = "") String pho,
                                       @RequestParam(value = "email", defaultValue = "") String email,
                                       @RequestParam(value = "oldName", defaultValue = "") String oldName,
                                       Model model){
        System.out.println(userName);
        System.out.println(oldName);
        Manager oldManager=ManagerTools.findManagerByUserName(oldName);
        oldManager.setFirstName(firstName);
        oldManager.setLastName(lastName);
        oldManager.setUserName(userName);
        oldManager.setPassword(password);
        oldManager.setPhoneNo(pho);
        oldManager.setEmail(email);
        ManagerTools.updateOneManager(oldManager);
        return "redirect:/manager/manageManager";
    }

    @RequestMapping(value ="/changeuserinfo/{userName}",method = POST) // 相应的请求方法
    public String changeCommonUserInfo(
            @RequestParam(value = "lastName", defaultValue = "") String lastName,
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "userName", defaultValue = "") String userName,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "pho", defaultValue = "") String pho,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "oldName", defaultValue = "") String oldName,
            Model model){
        System.out.println(oldName);
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
     * 创建管理员页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add.do", method = GET)
    public String addManager(Model model) {
        return "addManager";
    }

    /**
     * 创建管理员页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout.do", method = GET)
    public String logOut(Model model,HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    /**
     * 提交信息，提交成功后跳转到用户信息
     *
     * @param manager
     * @param errors
     * @return
     */
    @RequestMapping(value = "/add.do", method = POST)
    public String processAddManager(@Valid Manager manager, Errors errors, HttpSession session) {
        if (errors.hasErrors()) {
            return "/manager/add.do";
        }
        Manager newmanager=ManagerTools.addManager(manager);
        return "redirect:/manager/manageManager";
    }
    /**
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


    @RequestMapping(value = "/searchManager.do", method = POST)
    public String processSearchManager(@RequestParam(value = "userName", defaultValue = "") String userName,
                                       Model model) {
        System.out.println(userName);
        Manager searchManager=ManagerTools.findManagerByUserName(userName);
        if(searchManager!=null){
            model.addAttribute("userName",searchManager.getUserName());
        }
        return "redirect:/manager/manageManager";
    }

    @RequestMapping(value = "/searchCommonUser.do", method = POST)
    public String processSearchCommonUser(@RequestParam(value = "userName", defaultValue = "") String userName,
                                       Model model) {
        System.out.println(userName);
        CommonUser searchCommonUser=CommonUserTools.readOneUser(userName);
        if(searchCommonUser!=null){
            model.addAttribute("userName",searchCommonUser.getUserName());
        }
        return "redirect:/manager/manageUser";
    }

}
