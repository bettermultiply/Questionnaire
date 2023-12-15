package questionnaire.web.filter;

import org.springframework.beans.factory.annotation.Autowired;
import questionnaire.database.CommonUser;
import questionnaire.web.dao.CommonUserDao;
import questionnaire.web.dao.impl.CommonUserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * the class is used to filter request without user account
 */
public class UserFilter implements Filter {
    private final CommonUserDaoImpl commonUserDao = new CommonUserDaoImpl();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * filter request without user account
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        CommonUser user = (CommonUser) session.getAttribute("commonUser");
        if (user != null && commonUserDao.verifyCommonUser(user.getUserName(), user.getPassword()) != null) {
            filterChain.doFilter(request, response);
            return;
        }
        request.getRequestDispatcher("/commonuser/login").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}
