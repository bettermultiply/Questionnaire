package questionnaire.web;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.database.*;
import questionnaire.utils.ChoiceTools;
import questionnaire.utils.SessionFactorySource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class TestController {


    @RequestMapping(method = RequestMethod.GET)
    public String HomeDataInit() throws HibernateException {
        Session session;
        session = SessionFactorySource.getSessionFactory().openSession();
        session.beginTransaction();
        QChoose choose = new QChoose("1", "test", null, null, true, null);
//        ChoiceResult result = new ChoiceResult()
        Choice choice = new Choice(choose, "Hello BetMul", "");
//        List<Choice> list = new ArrayList<Choice>();
//        list.add(choice);
//        choose.setChoices(list);
        session.save(choose);
//        session.save(choice);
        session.getTransaction().commit();

        ChoiceTools.createChoice(choice);
        List<Choice> newchoice = ChoiceTools.readChoice(choose.getQuestionId());
        System.out.println(newchoice.isEmpty());
        session.close();
        return "welcome";
    }
}
