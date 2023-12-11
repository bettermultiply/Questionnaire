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

    public static void deleteQuestionnaire(String id){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            QuestionnaireTable table = readOneQuestionnaire(id);
            session.beginTransaction();
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

    //读取单一问卷信息
    public static QuestionnaireTable readOneQuestionnaire(String id){
        String hql = "FROM QuestionnaireTable where id='" + id + "'";
        return readQuestionnaire(hql).get(0);
    }

    //读取单个用户的所有问卷
    public static List<QuestionnaireTable> readOneUerQuestionnaire(String parentid){
        String hql = "FROM QuestionnaireTable where userId='" + parentid + "'";
        return readQuestionnaire(hql);
    }

    //读取所有问卷
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
