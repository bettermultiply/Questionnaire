package questionnaire.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import questionnaire.database.Manager;
import questionnaire.utils.SessionFactorySource;
import questionnaire.web.dao.ManagerDao;

import java.util.List;

/**
 * 管理员Dao实现类
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public Manager verifyManager(String username, String password) {
        Manager manager = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            // 使用HQL查询管理员对象
            // 使用参数化查询，避免SQL注入
            String hql = "FROM Manager WHERE userName =:username AND password = :password";
            Query<Manager> query = session.createQuery(hql, Manager.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            List<Manager> managers = query.list();

            session.getTransaction().commit();

            // 如果查询结果不为空，说明用户名和密码匹配
            if (!managers.isEmpty()) {
                manager = managers.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Manager findManagerByUserName(String username) {
        Manager manager = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            // 使用HQL查询管理员对象
            // 使用参数化查询，避免SQL注入
            String hql = "FROM Manager WHERE userName =:username";
            Query<Manager> query = session.createQuery(hql, Manager.class);
            query.setParameter("username", username);

            List<Manager> managers = query.list();

            //System.out.println(managers);
            // 提交事务
            session.getTransaction().commit();

            // 如果查询结果不为空，说明用户名和密码匹配
            if (!managers.isEmpty()) {
                manager = managers.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Manager addManager(Manager manager) {
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(manager);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteManager(String managerId) {
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            Manager manager = session.load(Manager.class, managerId);
            if(!manager.getUserName().equals("admin")) {
                session.delete(manager);
                session.getTransaction().commit();
            }else {
                throw new HibernateException("The admin Manager cannot be deleted!");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Manager> getAllManagers() {
        List<Manager> managers = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Manager ";
            Query<Manager> query = session.createQuery(hql, Manager.class);

            managers = query.list();

            //System.out.println(managers);
            // 提交事务
            session.getTransaction().commit();

            // 如果查询结果不为空，说明用户名和密码匹配
            if (managers.isEmpty()) {
                return null;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return managers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOneManager(Manager manager) {
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(manager);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
