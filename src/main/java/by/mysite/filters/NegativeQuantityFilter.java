package by.mysite.filters;

import by.mysite.constants.JspConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

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
        Object attribute = req.getAttribute(JspConstant.FOOD_QUANTITY_PARAM);

    }
}
