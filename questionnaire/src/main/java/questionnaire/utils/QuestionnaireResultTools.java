package questionnaire.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import questionnaire.database.ChoiceResult;
import questionnaire.database.QuestionnaireResult;
import questionnaire.database.QuestionnaireTable;

import java.util.List;

public class QuestionnaireResultTools {

    public static void createQuestionnaireResult(QuestionnaireResult table){
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(table);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    public static void deleteQuestionnaireResult(String id){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            QuestionnaireResult table = session.load(QuestionnaireResult.class, id);
            session.beginTransaction();
            session.delete(table);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void updateQuestionnaireResult(QuestionnaireResult table){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(table);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static List<QuestionnaireTable> readQuestionnaireResult(String parentId){
        List<QuestionnaireTable> tables = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM QuestionnaireResult where parentTable=:parentId";
            tables = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return tables;
    }
}
