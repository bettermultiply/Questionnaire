package questionnaire.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import questionnaire.database.Choice;
import questionnaire.database.QChoose;
import questionnaire.database.QuestionnaireTable;

import java.util.List;

public class QuestionnaireTools {

    public static void createQuestionnaire(QuestionnaireTable table){
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(table);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    public static void deleteQuestionnaire(Integer id){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            QuestionnaireTable table = (QuestionnaireTable) session.load(QuestionnaireTable.class, id);
            session.delete(table);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void updateQuestionnaire(QuestionnaireTable table){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(table);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    public static List<QuestionnaireTable> readOneQuestionnaire(String parentid){
        String hql = "FROM QuestionnaireTable where belongs=" + parentid;
        return readQuestionnaire(hql);
    }

    //TODO how to protect the method to only the manager can use it ? Maybe no need to do that
    public static List<QuestionnaireTable> readAllQuestionnaires(){
        String hql = "FROM QuestionnaireTable";
        return readQuestionnaire(hql);
    }

    private static List<QuestionnaireTable> readQuestionnaire(String hql){
        List<QuestionnaireTable> tables = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            tables = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return tables;
    }


}
