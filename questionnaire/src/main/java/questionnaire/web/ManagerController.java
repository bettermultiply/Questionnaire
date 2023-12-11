package questionnaire.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import questionnaire.database.Manager;
import questionnaire.utils.ManagerTools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                                      @RequestParam(value = "password", defaultValue = "") String password, HttpSession session, HttpServletRequest request){
        Manager manager = ManagerTools.verifyManager(userName, password);
        if(manager != null ){
            session.setAttribute("manager",manager);
            //return "managerAccount";
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
    public String managerAccountManage(Model model) {
        return "managerAccount";
    }

    /**
     * 管理员信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/manageUser", method = GET)
    public String userAccountManage(Model model) {
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
    @RequestMapping(value ="/{userName}/viewMe",method = GET) // 相应的请求方法
    public String showManagerViewMe(@PathVariable String userName,Model model){
        Manager manager = ManagerTools.findManagerByUserName(userName);
        model.addAttribute(manager);
        return "viewMe";
    }
}
