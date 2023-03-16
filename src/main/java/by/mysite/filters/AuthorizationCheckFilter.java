package by.mysite.filters;

import by.mysite.constants.JspConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(filterName = "AuthorizationCheckFilter", value = {JspConstant.HOME_JSP, JspConstant.CART_JSP})
public class AuthorizationCheckFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(JspConstant.USER_ATTR);

        if (Objects.isNull(attribute)) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect(request.getContextPath() + JspConstant.LOGIN_JSP);
            return;
        }
        chain.doFilter(req, resp);
    }
}
