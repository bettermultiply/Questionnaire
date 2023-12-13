package questionnaire.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import questionnaire.database.Choice;
import questionnaire.database.ChoiceResult;

import java.util.List;

public class ChoiceResultTools {

    public static void createChoiceResult(ChoiceResult choiceResult){
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(choiceResult);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    public static void deleteChoiceResult(String id){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            ChoiceResult choiceResult = session.load(ChoiceResult.class, id);
            session.delete(choiceResult);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void updateChoiceResult(ChoiceResult choiceResult){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(choiceResult);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static List<ChoiceResult> readChoiceResultByChoose(String parentid){
        List<ChoiceResult> choiceResults = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM ChoiceResult where parentChosenResult='" + parentid + "'";
            choiceResults = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return choiceResults;
    }

    public static List<ChoiceResult> readChoiceResultByModel(String modelId){
        List<ChoiceResult> choiceResults = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM ChoiceResult where modelChoice='" + modelId + "'";
            choiceResults = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return choiceResults;
    }
}
