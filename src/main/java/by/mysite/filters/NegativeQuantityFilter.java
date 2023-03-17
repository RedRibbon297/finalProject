package by.mysite.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static by.mysite.constants.JspConstant.FOOD_QUANTITY_PARAM;
import static by.mysite.constants.JspConstant.HOME_JSP;
import static by.mysite.constants.JspConstant.MESSAGE_ATTR;

@WebFilter(filterName = "NegativeQuantityFilter", servletNames = {"CartController"})
public class NegativeQuantityFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String parameter = request.getParameter(FOOD_QUANTITY_PARAM);
        int quantity = Integer.parseInt(parameter);
        if (quantity < 1) {
            RequestDispatcher rd = request.getRequestDispatcher(HOME_JSP);
            request.setAttribute(MESSAGE_ATTR, "Negative quantity!");
            rd.forward(req, resp);
            return;
        }
        chain.doFilter(req, resp);
    }
}
