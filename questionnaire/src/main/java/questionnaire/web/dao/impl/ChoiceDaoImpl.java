package questionnaire.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import questionnaire.database.Choice;
import questionnaire.utils.SessionFactorySource;
import questionnaire.web.dao.ChoiceDao;

import java.util.List;

/**
 * 选项Dao的实现类
 */
@Repository
public class ChoiceDaoImpl implements ChoiceDao {
    /**
     * {@inheritDoc}
     */
    @Override
    public void addChoice(Choice choice) {
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(choice);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteChoice(String choiceId) {
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            Choice choice = session.load(Choice.class, choiceId);
            session.delete(choice);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Choice readOneChoice(String choiceId) {
        List<Choice> choices = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Choice where choiceId='" + choiceId + "'";
            choices = session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return choices.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateChoice(Choice choice) {
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(choice);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
