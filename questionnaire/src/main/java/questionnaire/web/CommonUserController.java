package questionnaire.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import questionnaire.database.CommonUser;
import questionnaire.utils.CommonUserTools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Arrays;

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

    /**
     * todo：cookies 设置有问题，当有其他用户需要在同一浏览器注册时，点击登录仍然自动登陆到上一用户
     * @param lastName
     * @param firstName
     * @param userName
     * @param password
     * @param pho
     * @param email
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value ="/register",method =POST) // 相应的请求方法
    public String commonUserRegister(@RequestParam(value = "lastName", defaultValue = "") String lastName,
                                     @RequestParam(value = "firstName", defaultValue = "") String firstName,
                                     @RequestParam(value = "userName", defaultValue = "") String userName,
                                     @RequestParam(value = "password", defaultValue = "") String password,
                                     @RequestParam(value = "pho", defaultValue = "") String pho,
                                     @RequestParam(value = "email", defaultValue = "") String email,
                                     HttpServletRequest request,
                                     HttpServletResponse response,
                                     Model model){
        //todo: 如何设置cookie在浏览器端失效
//        Cookie [] cookies=request.getCookies();
//        for (Cookie cookie : cookies) {
//            String cookieName = cookie.getName();
//            if ("userName".equals(cookieName)) {
//                cookie.setValue("-1");
//                cookie.setPath("/questionnaire/questionnaire");
//                cookie.setMaxAge(0);
//                response.addCookie(cookie);
//                break;
//            }
//        }
        if(CommonUserTools.readOneUser(userName)!=null){
            model.addAttribute("taken", true);
            return "register";
        }
        CommonUser commonUser=new CommonUser();
        commonUser.setFirstName(firstName);
        commonUser.setLastName(lastName);
        commonUser.setUserName(userName);
        commonUser.setPassword(password);
        commonUser.setPhoneNo(pho);
        commonUser.setEmail(email);
        CommonUser cUser=CommonUserTools.registerCommonUser(commonUser);
        if(cUser!=null){
            return "redirect:/";
        }
        return  "redirect:/commonuser/register";
    }


    @RequestMapping(value ="/login",method = GET) // 相应的请求方法
    public String commonUserLogin(Model model,HttpServletRequest request,HttpSession session){
        //若cookie校验通过则自动登录
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length>0){
            for(Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if("userName".equals(cookieName)){
                    String cookieValue = cookie.getValue();
                    CommonUser commonUser = CommonUserTools.readOneUser(cookieValue);
                    if(commonUser!=null){
                        session.setAttribute("commonUser",commonUser);
                        return "redirect:/questionnaire";
                    }
                }
            }
        }
        return "loginUser";
    }

    @RequestMapping(value ="/login",method = POST) // 相应的请求方法
    public String commonUserLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
                                  @RequestParam(value = "password", defaultValue = "") String password, HttpSession session,HttpServletResponse response){

        CommonUser commonUser = CommonUserTools.verifyUser(userName, password);
        if(commonUser != null ){
            session.setAttribute("commonUser",commonUser);
            return "redirect:/questionnaire";
        }else {
            return "redirect:/commonuser/login";
        }
    }


    @RequestMapping(value = "/logout.do", method = GET)
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

