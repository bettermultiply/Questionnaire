package questionnaire.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import questionnaire.database.ChoiceResult;
import questionnaire.database.QuestionTypeResult;
import questionnaire.database.QuestionnaireResult;
import questionnaire.utils.SessionFactorySource;
import questionnaire.web.dao.QuestionResultDao;

import java.util.List;

@Repository
public class QuestionResultDaoImpl implements QuestionResultDao {
    /**
     * {@inheritDoc}
     */
    @Override
    public String addQuestionTypeResult(QuestionTypeResult questionTypeResult) {
        String questionTypeId = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            questionTypeId = (String) session.save(questionTypeResult);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return questionTypeId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String addQuestionnaireResult(QuestionnaireResult questionnaireResult) {
        String  questionnaireResultId = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            questionnaireResultId = (String) session.save(questionnaireResult);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return questionnaireResultId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addChoiceResult(ChoiceResult choiceResult) {
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(choiceResult);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<QuestionTypeResult> readResultsByModel(String parentid) {
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
