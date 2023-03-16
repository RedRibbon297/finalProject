package by.mysite.controllers.order;

import by.mysite.constants.ApplicationConstant;
import by.mysite.constants.JspConstant;
import by.mysite.controllers.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.mysite.constants.JspConstant.ORDER_ID_ATTR;
import static by.mysite.constants.JspConstant.ORDER_ITEMS_ATTR;

@WebServlet(name = "OrderController", value = ApplicationConstant.ORDER_CONTROLLER)
public class OrderController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter(JspConstant.ADDRESS_PARAM);
        HttpSession session = req.getSession();

        if (orderService.saveOrder(session, address)) {
            String orderId = (String) session.getAttribute(ORDER_ID_ATTR);
            session.removeAttribute(ORDER_ID_ATTR);
            session.removeAttribute(ORDER_ITEMS_ATTR);
            forward(req, resp, JspConstant.HOME_JSP, "Your order ID is " + orderId + ", you can print it on Orders page.");
        } else {
            forward(req, resp, JspConstant.CART_JSP, "BAD");
        }
    }
}
