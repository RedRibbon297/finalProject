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

import static by.mysite.constants.ApplicationConstant.ORDERS_HISTORY_CONTROLLER;
import static by.mysite.constants.ApplicationConstant.REMOVE_ORDER_CONTROLLER;
import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "RemoveOrderController", value = REMOVE_ORDER_CONTROLLER)
public class RemoveOrderController extends AbstractOrderController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter(ORDER_ID_ATTR);
        orderService.removeOrderById(orderId);
        forward(req, resp, ORDERS_HISTORY_CONTROLLER);
    }
}
