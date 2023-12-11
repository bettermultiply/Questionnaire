package questionnaire.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import questionnaire.database.Choice;
import questionnaire.database.CommonUser;
import questionnaire.database.QuestionType;
import questionnaire.database.QuestionnaireTable;

import java.util.List;

public class CommonUserTools {

    public static void createCommonUser(CommonUser commonUser){
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(commonUser);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    public static CommonUser readOneUser(String userName){
        List<CommonUser> users = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM CommonUser where userName='" + userName + "'";
            users = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return users.get(0);
    }

    public static CommonUser registerCommonUser(CommonUser cUser){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(cUser);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return  cUser;
    }
}
