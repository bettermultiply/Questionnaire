package questionnaire.web.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import questionnaire.database.Manager;
import questionnaire.utils.ManagerTools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * the class is used to intercept people without manager account
 */
public class ManagerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        System.out.println("executed preHandle");
        Manager manager = (Manager) session.getAttribute("manager");
        if (manager != null && ManagerTools.verifyManager(manager.getUserName(), manager.getPassword()) != null) {
            return true;
        }
        //TODO other page maybe better
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    /**
     * post handle
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handler");
    }

    /**
     * after comple
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("excuted after");
    }
}
