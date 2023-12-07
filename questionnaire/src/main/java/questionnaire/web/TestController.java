package questionnaire.web;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.database.ChosenResult;
import questionnaire.database.QChooseResult;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class TestController {


    @RequestMapping(method = RequestMethod.GET)
    public String HomeDataInit() throws HibernateException {
        Session session;
        Configuration config = new Configuration().configure();
        session = config.buildSessionFactory().openSession();
        QChooseResult result = new QChooseResult();
        result.setChooseResultId(1);
        Set<ChosenResult> orders = new HashSet<ChosenResult>();
        ChosenResult r1 = new ChosenResult();
        r1.setOrders(1);
        ChosenResult r2 = new ChosenResult();
        r2.setOrders(2);
        ChosenResult r3 = new ChosenResult();
        r3.setOrders(3);
        orders.add(r1);
        orders.add(r2);
        orders.add(r3);

        result.setChosenOrders(orders);

        session.save(result);
        session.save(r1);
        session.save(r2);
        session.save(r3);
        session.beginTransaction().commit();


        System.out.println("ok");
        session.close();
        return "welcome";
    }
}
