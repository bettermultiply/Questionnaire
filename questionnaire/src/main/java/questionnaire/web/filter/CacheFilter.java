package questionnaire.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * set the header Cache-Control: no-store for every response
 */
public class CacheFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * post handle
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Cache-Control", "no-store");
        filterChain.doFilter(request, response);
    }

    /**
     * after comple
     */
    @Override
    public void destroy() {
    }
}
