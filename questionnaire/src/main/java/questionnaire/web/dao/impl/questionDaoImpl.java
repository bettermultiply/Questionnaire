package questionnaire.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import questionnaire.database.QuestionType;
import questionnaire.utils.SessionFactorySource;
import questionnaire.web.dao.QuestionDao;

import java.util.List;

@Repository
public class questionDaoImpl implements QuestionDao {
    @Override
    public List<QuestionType> readQuestion(String questionnaireId) {
        List<QuestionType> questions = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM QuestionType where tableId='" + questionnaireId + "'";
            questions = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return questions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createQuestion(QuestionType questionType) {
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(questionType);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
