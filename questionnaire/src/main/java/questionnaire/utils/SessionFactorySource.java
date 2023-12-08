package questionnaire.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactorySource {

    private static final SessionFactory source = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSessionFactory(){
        return source;
    }
}
