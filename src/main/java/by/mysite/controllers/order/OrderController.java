package by.mysite.controllers.order;

import by.mysite.controllers.abstracts.AbstractOrderController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.mysite.constants.ApplicationConstant.ORDER_CONTROLLER;
import static by.mysite.constants.JspConstant.ORDER_ID_ATTR;
import static by.mysite.constants.JspConstant.ORDER_ITEMS_ATTR;
import static by.mysite.constants.JspConstant.ADDRESS_PARAM;
import static by.mysite.constants.JspConstant.HOME_JSP;
import static by.mysite.constants.JspConstant.CART_JSP;

@WebServlet(name = "OrderController", value = ORDER_CONTROLLER)
public class OrderController extends AbstractOrderController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter(ADDRESS_PARAM);
        HttpSession session = req.getSession();

        if (orderService.saveOrder(session, address)) {
            String orderId = (String) session.getAttribute(ORDER_ID_ATTR);
            session.removeAttribute(ORDER_ID_ATTR);
            session.removeAttribute(ORDER_ITEMS_ATTR);
            forward(req, resp, HOME_JSP, "Your order ID is " + orderId + ", you can print it on Orders page.");
        } else {
            forward(req, resp, CART_JSP, "BAD");
        }
    }
}
