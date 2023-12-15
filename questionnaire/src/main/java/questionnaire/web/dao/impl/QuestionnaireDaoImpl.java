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
        String hql = "FROM QuestionnaireTable where userId='" + userId + "'";
        return readQuestionnaire(hql);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<QuestionnaireTable> getCheckedQuestionnaire(String userId) {
        String hql = "FROM QuestionnaireTable where userId='" + userId + "'" + "AND is_checked=1";
        return readQuestionnaire(hql);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<QuestionnaireTable> getUncheckedQuestionnaire(String userId) {
        String hql = "FROM QuestionnaireTable where userId='" + userId + "'" + "AND is_checked=0";
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
    public void updateQuestionnaire(QuestionnaireTable questionnaireTable) {
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(questionnaireTable);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<QuestionType> getAllQuestionsAndChoices(String questionnaireId) {
        return null;
    }

    @Override
    public List<QuestionnaireTable> readAllUncheckedQuestionnaires() {
        String hql = "FROM QuestionnaireTable where is_checked=0";
        return readQuestionnaire(hql);
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
