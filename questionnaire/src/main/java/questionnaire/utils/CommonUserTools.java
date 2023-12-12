package questionnaire.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import questionnaire.database.CommonUser;

import java.util.List;

public class CommonUserTools {

    public static CommonUser verifyCommonUser(String username, String password) {
        CommonUser user = null;
        try (Session session = SessionFactorySource.getSessionFactory().openSession()) {
            session.beginTransaction();
            // 使用HQL查询管理员对象
            // 使用参数化查询，避免SQL注入
            String hql = "FROM CommonUser WHERE userName =:username AND password = :password";
            Query<CommonUser> query = session.createQuery(hql, CommonUser.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            List<CommonUser> users = query.list();

            // 提交事务
            session.getTransaction().commit();

            // 如果查询结果不为空，说明用户名和密码匹配
            if (!users.isEmpty()) {
                user = users.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static CommonUser readOneUser(String userName){
        List<CommonUser> users = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "FROM CommonUser where userName='" + userName + "'";
            users = session.createQuery(hql).list();
            if(users.isEmpty()){
                return null;
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return users.get(0);
    }

    public static CommonUser registerCommonUser(CommonUser cUser){
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            if(readOneUser(cUser.getUserName())==null){
                session.save(cUser);
            }else {
                return null;
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return cUser;
    }

    public static CommonUser verifyUser(String username , String password){
        CommonUser cUser = null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            // 使用HQL查询管理员对象
            // 使用参数化查询，避免SQL注入
            String hql = "FROM CommonUser WHERE userName =:username AND password = :password";
            Query<CommonUser> query = session.createQuery(hql, CommonUser.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            List<CommonUser> cUsers = query.list();

            System.out.println(cUsers);
            // 提交事务
            session.getTransaction().commit();

            // 如果查询结果不为空，说明用户名和密码匹配
            if (!cUsers.isEmpty()) {
                cUser = cUsers.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return cUser;
    }

    public static List<CommonUser> getAllCommonUsers(){
        List<CommonUser> commonUsers=null;
        try(Session session = SessionFactorySource.getSessionFactory().openSession()){
            session.beginTransaction();
            // 使用HQL查询管理员对象
            // 使用参数化查询，避免SQL注入
            String hql = "FROM CommonUser ";
            Query<CommonUser> query = session.createQuery(hql, CommonUser.class);

            commonUsers = query.list();


            // 提交事务
            session.getTransaction().commit();

            // 如果查询结果不为空，说明用户名和密码匹配
            if (commonUsers.isEmpty()) {
                return null;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return commonUsers;
    }
}
