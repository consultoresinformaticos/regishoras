package business.boundary;

import java.io.IOException;
import javax.inject.Inject;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentation.LoginBean;

@WebFilter(urlPatterns = "/secure-/*")
public class AuthFilter implements Filter {

    @Inject
    LoginBean loginBean;
    /**
     * Default constructor.
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }   

    /**
     * @param request
     * @param response
     * @param chain
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        if (loginBean == null || !loginBean.isLoggedIn()) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        }

        chain.doFilter(request, response);
    }

    /**
     * @param fConfig
     * @throws javax.servlet.ServletException
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}