package questionnaire.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import questionnaire.database.QuestionType;
import questionnaire.database.QuestionTypeResult;

import java.util.List;

public class QuestionResultTools {
    public static void createResult(QuestionType question){
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(question);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

// 不允许删除
//    public static void deleteResult(Integer id){
//        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
//            session.beginTransaction();
//            QuestionType question = (QuestionType) session.load(QuestionType.class, id);
//            session.delete(question);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }
// 不允许更新
//    public static void updateQuestion(QuestionType question){
//        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
//            session.beginTransaction();
//            session.update(question);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<QuestionTypeResult> readResults(String parentid){
        List<QuestionTypeResult> results = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM QuestionTypeResult where parentResult='" + parentid + "'";
            results = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return results;
    }

    public static List<QuestionTypeResult> readResultsByModel(String parentid){
        List<QuestionTypeResult> results = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM QuestionTypeResult where modelType='" + parentid + "'";
            results = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return results;
    }
}
