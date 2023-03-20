package by.mysite.controllers.order;

import by.mysite.controllers.abstracts.AbstractOrderController;
import by.mysite.model.entities.order.Order;
import by.mysite.model.entities.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.mysite.constants.JspConstant.USER_ATTR;
import static by.mysite.constants.JspConstant.ORDERS_LIST_ATTR;
import static by.mysite.constants.JspConstant.ORDERS_JSP;
import static by.mysite.constants.ApplicationConstant.ORDERS_HISTORY_CONTROLLER;

@WebServlet(name = "OrderHistoryController", value = ORDERS_HISTORY_CONTROLLER)
public class OrderHistoryController extends AbstractOrderController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = ((User) session.getAttribute(USER_ATTR)).getId();
        List<Order> ordersList = orderService.getOrdersList(userId);
        req.setAttribute(ORDERS_LIST_ATTR, ordersList);
        forward(req, resp, ORDERS_JSP);
    }
}
