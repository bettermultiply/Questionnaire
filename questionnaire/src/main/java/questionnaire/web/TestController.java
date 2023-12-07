package questionnaire.web;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.database.ChoiceResult;
import questionnaire.database.QChooseResult;
import questionnaire.database.QuestionType;
import questionnaire.database.QuestionTypeResult;

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
        result.setResultId(1);
        Set<ChoiceResult> orders = new HashSet<ChoiceResult>();
        ChoiceResult r1 = new ChoiceResult();
        r1.setChoiceResultId(1);
        ChoiceResult r2 = new ChoiceResult();
        r2.setChoiceResultId(2);
        ChoiceResult r3 = new ChoiceResult();
        r3.setChoiceResultId(3);
        orders.add(r1);
        orders.add(r2);
        orders.add(r3);

        result.setResults(orders);

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
