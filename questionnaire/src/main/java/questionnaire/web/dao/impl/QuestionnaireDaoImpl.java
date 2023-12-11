package questionnaire.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import questionnaire.database.QuestionType;
import questionnaire.database.QuestionnaireTable;
import questionnaire.utils.SessionFactorySource;
import questionnaire.web.dao.QuestionnaireDao;

import java.util.List;

@Repository
public class QuestionnaireDaoImpl implements QuestionnaireDao {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<QuestionnaireTable> getAllQuestionnaires(String userId) {
        String hql = "FROM QuestionnaireTable";
        return readQuestionnaire(hql);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionnaireTable getOneQuestionnaire(String questionnaireId) {
        String hql = "FROM QuestionnaireTable where id='" + questionnaireId + "'";
        return readQuestionnaire(hql).get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteQuestionnaire(String questionnaireId) {
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            QuestionnaireTable table = session.load(QuestionnaireTable.class, questionnaireId);
            session.delete(table);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String addQuestionnaire(QuestionnaireTable questionnaireTable) {
        String questionnaireId = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            questionnaireId = (String) session.save(questionnaireTable);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return questionnaireId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<QuestionType> getAllQuestionsAndChoices(String questionnaireId) {
        return null;
    }

    private List<QuestionnaireTable> readQuestionnaire(String hql){
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
