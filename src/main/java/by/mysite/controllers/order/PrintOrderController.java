package by.mysite.controllers.order;

import by.mysite.constants.ApplicationConstant;
import by.mysite.controllers.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "PrintOrderController", value = ApplicationConstant.PRINT_ORDER_CONTROLLER)
public class PrintOrderController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter(ORDER_ID_ATTR);
        String receipt = orderService.getReceipt(orderId);
        req.setAttribute(RECEIPT_ATTR, receipt);
        forward(req, resp, RECEIPT_JSP);
    }
}
