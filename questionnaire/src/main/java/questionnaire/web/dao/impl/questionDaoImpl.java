package questionnaire.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import questionnaire.database.Choice;
import questionnaire.database.QChoose;
import questionnaire.database.QuestionType;
import questionnaire.utils.SessionFactorySource;
import questionnaire.web.dao.QuestionDao;

import java.util.Comparator;
import java.util.List;

@Repository
public class questionDaoImpl implements QuestionDao {
    /**
     * {@inheritDoc}
     */
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
        if (questions != null){
            questions.sort(Comparator.comparing(QuestionType::getQuestionOrder));
        }

        return questions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionType readOneQuestion(String questionId) {
        List<QuestionType> questions = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM QuestionType where questionId='" + questionId + "'";
            questions = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return questions.get(0);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteQuestion(String questionId) {
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            QuestionType question = session.load(QuestionType.class, questionId);
            session.delete(question);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateQuestion(QuestionType question) {
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(question);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
