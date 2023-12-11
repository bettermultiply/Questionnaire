package questionnaire.web;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.utils.SessionFactorySource;

@Controller
@RequestMapping("/")
public class TestController {


    @RequestMapping(method = RequestMethod.GET)
    public String HomeDataInit() throws HibernateException {
        try (Session session = SessionFactorySource.getSessionFactory().openSession();){
            System.out.println("Create");
        }
        return "welcome";
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String StatisticsDataInit() throws HibernateException {
        try (Session session = SessionFactorySource.getSessionFactory().openSession();){
            System.out.println("Create");
        }
        return "statistics";
    }
}
