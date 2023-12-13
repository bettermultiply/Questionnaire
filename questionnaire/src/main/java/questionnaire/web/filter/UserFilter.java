package questionnaire.web.filter;

import org.springframework.web.servlet.ModelAndView;
import questionnaire.database.CommonUser;
import questionnaire.database.Manager;
import questionnaire.utils.CommonUserTools;
import questionnaire.utils.ManagerTools;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * post handle
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        CommonUser user = (CommonUser) session.getAttribute("commonUser");
        if (user != null && CommonUserTools.verifyCommonUser(user.getUserName(), user.getPassword()) != null) {
            filterChain.doFilter(request, response);
            return;
        }
        request.getRequestDispatcher("/commonuser/login").forward(request, response);
    }

    /**
     * after comple
     */
    @Override
    public void destroy() {
    }
}
