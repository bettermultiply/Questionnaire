package questionnaire.config;


import org.h2.server.web.WebServlet;
import org.hibernate.Session;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import questionnaire.database.Manager;
import questionnaire.utils.SessionFactorySource;
import questionnaire.web.filter.CacheFilter;
import questionnaire.web.filter.ManagerFilter;
import questionnaire.web.filter.UserFilter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        // 启动h2数据库控制台，通过http://localhost:8080/console访问数据库管理工具
        // 默认使用数据库URL jdbc:h2:mem:testdb 用户名sa 密码 空

        ServletRegistration.Dynamic servlet = servletContext.addServlet("h2-console", new WebServlet());
        servlet.setLoadOnStartup(2);
        servlet.addMapping("/console/*");

        Session session;
        session = SessionFactorySource.getSessionFactory().openSession();
        session.beginTransaction();
        Manager manager = new Manager();
        manager.setUserName("admin");
        manager.setPassword("admin");
        session.save(manager);
        session.getTransaction().commit();
        session.close();
    }
}
