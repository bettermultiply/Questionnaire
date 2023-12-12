package questionnaire.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import questionnaire.database.CommonUser;
import questionnaire.database.Manager;
import questionnaire.utils.CommonUserTools;
import questionnaire.utils.ManagerTools;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by zong chang on 2023/12/11 13:00
 */

@Controller // 控制定义

@SessionAttributes({ "commonuser" })
@RequestMapping("/commonuser") // 相应web路径
public class CommonUserController {

    /**
     * 普通用户注册
     *
     * @param model
     * @return
     */
    @RequestMapping(value ="/register",method = GET) // 相应的请求方法
    public String commonUserRegister(Model model){
        model.addAttribute(new CommonUser());
        return "register";
    }

    @RequestMapping(value ="/register",method =POST) // 相应的请求方法
    public String commonUserRegister(@RequestParam(value = "userName", defaultValue = "") String userName,
                                     @RequestParam(value = "password", defaultValue = "") String password,   HttpSession session){
        CommonUser commonUser=new CommonUser();
        commonUser.setUserName(userName);
        commonUser.setPassword(password);
        CommonUser cUser=CommonUserTools.registerCommonUser(commonUser);
        if(cUser!=null){
            return "redirect:/";
        }
        return  "registerFailedPage";
    }


    @RequestMapping(value ="/login",method = GET) // 相应的请求方法
    public String commonUserLogin(Model model){
        return "loginUser";
    }

    @RequestMapping(value ="/login",method = POST) // 相应的请求方法
    public String commonUserLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
                                  @RequestParam(value = "password", defaultValue = "") String password, HttpSession session){

        System.out.println(userName);
        System.out.println(password);
        CommonUser commonUser = CommonUserTools.verifyUser(userName, password);
        if(commonUser != null ){
            session.setAttribute("commonUser",commonUser);
            //return "managerAccount";
            return "redirect:/commonuser/"+commonUser.getUserName();
        }else {
            return "redirect:/commonuser/login";
        }
    }

    /**
     * 用户信息页面
     *
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(value = "/{userName}", method = GET)
    public String showCommonUserHome(@PathVariable String userName, Model model) {
        /*
         * @PathVariable("xxx") 通过 @PathVariable
         * 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
         * 用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出uri模板中的变量作为参数
         */
        System.out.println(userName);
        CommonUser cUser = CommonUserTools.readOneUser(userName);
        if (cUser != null) {
            model.addAttribute(cUser);
            return "TestPage";
        } else {
            return "redirect:/commonuser/login";
        }
    }

}

