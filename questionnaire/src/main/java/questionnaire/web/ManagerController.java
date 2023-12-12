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
    public String managerAccountManage(Model model,HttpSession session) {
        if(session.getAttribute("manager")  !=null&&session.getAttribute("manager")  instanceof Manager){
            List<Manager> managerList=ManagerTools.getAllManagers();
            if(managerList!=null){
                model.addAttribute("managerList", managerList);
                return "managerAccount";
            }
            else {}
        }
        else {

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
    public String userAccountManage(Model model) {
        List<CommonUser> commonUserList=CommonUserTools.getAllCommonUsers();
        if(commonUserList!=null){
            model.addAttribute("commonUserList", commonUserList);
        }
        else {
            return "noCommonUser";
        }
        return "managerUser";
    }

    /**
     * 管理员信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/manageQuestionnaire", method = GET)
    public String questionnaireManage(Model model) {
        return "managerQuestionnaire";

    }
    @RequestMapping(value ="/managerinfo/{userName}",method = GET) // 相应的请求方法
    public String showManagerViewMe(@PathVariable String userName,Model model){
        Manager manager = ManagerTools.findManagerByUserName(userName);
        if(manager!=null){
            model.addAttribute("manager",manager);
        }
        return "viewManagerInfo";
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
}
