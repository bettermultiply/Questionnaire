package questionnaire.web.controller;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by zong chang on 2023/12/11 11:00
 */

@Controller // 控制定义
@RequestMapping("/") // 相应web路径
public class HomePageController {
    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(method = GET) // 相应的请求方法
    public String homePage(Model model, HttpSession session) throws HibernateException {
        return "home";
    }
}
