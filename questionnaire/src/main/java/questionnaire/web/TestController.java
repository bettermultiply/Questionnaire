//package questionnaire.web;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import questionnaire.database.CommonUser;
//import questionnaire.utils.CommonUserTools;
//import questionnaire.utils.SessionFactorySource;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/")
//public class TestController {
//
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String HomeDataInit(HttpSession sessions) throws HibernateException {
//        try (Session session = SessionFactorySource.getSessionFactory().openSession();){
//            System.out.println("Create");
//        }
//        CommonUser user = GenerateNewUserForTest.Generate("bet");
//        CommonUserTools.registerCommonUser(user);
//        sessions.setAttribute("commonUser", user);
//        return "welcome";
//    }
//
//    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
//    public String StatisticsDataInit() throws HibernateException {
//        try (Session session = SessionFactorySource.getSessionFactory().openSession();){
//            System.out.println("Create");
//        }
//        return "statistics";
//    }
//}
