package questionnaire.web.filter;

import questionnaire.database.Manager;
import questionnaire.utils.ManagerTools;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * the class is used to intercept people without manager account
 */
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * post handle
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        if (manager != null && ManagerTools.verifyManager(manager.getUserName(), manager.getPassword()) != null) {
            filterChain.doFilter(request, response);
        }
        request.getRequestDispatcher("/manager/login").forward(request, response);
    }

    /**
     * after comple
     */
    @Override
    public void destroy() {
    }
}
