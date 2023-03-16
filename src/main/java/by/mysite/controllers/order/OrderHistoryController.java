package by.mysite.controllers.order;

import by.mysite.constants.ApplicationConstant;
import by.mysite.controllers.AbstractController;
import by.mysite.model.entities.order.Order;
import by.mysite.model.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "OrderHistoryController", value = ApplicationConstant.ORDERS_HISTORY_CONTROLLER)
public class OrderHistoryController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = ((User) session.getAttribute(USER_ATTR)).getId();
        //User user = (User) session.getAttribute(USER_ATTR);
        //int userId=user.getId();

        List<Order> ordersList = orderService.getOrdersList(userId);
        req.setAttribute(ORDERS_LIST_ATTR, ordersList);
        forward(req, resp, ORDERS_JSP);
    }
}
