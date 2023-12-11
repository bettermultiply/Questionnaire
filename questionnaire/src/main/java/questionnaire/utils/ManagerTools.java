package questionnaire.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import questionnaire.database.Manager;

import java.util.List;

/**
 * Created by zong chang on 2023/12/11 20:57
 */
public class ManagerTools {

    public static Manager verifyManager(String username ,String password){
        Manager manager = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            // 使用HQL查询管理员对象
            // 使用参数化查询，避免SQL注入
            String hql = "FROM Manager WHERE userName =:username AND password = :password";
            Query<Manager> query = session.createQuery(hql, Manager.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

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

    public static Manager findManagerByUserName(String username){
        Manager manager = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
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
}
