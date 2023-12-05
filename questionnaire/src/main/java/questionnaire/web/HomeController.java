package questionnaire.web;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.database.Manager;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


    @RequestMapping(method = RequestMethod.GET)
    public String HomeDataInit() throws HibernateException {
        //TODO: add and not recreate
        Session session;
        Configuration config = new Configuration().configure();
        session = config.buildSessionFactory().openSession();
        Manager manager = new Manager(1, "betmul");
//        manager.setId(1);
        session.save(manager);
        Manager managr = new Manager(1, "betmul");
//        manager.setId(1);
        session.save(managr);
        session.beginTransaction().commit();

        System.out.println("ok");
        List<Manager> managers = session.createQuery("FROM Manager", Manager.class).list();
        for(Manager m: managers){
            System.out.println(m.getName());
        }
        session.close();
        return "welcome";
    }
}
