package by.mysite.controllers.abstracts;

import by.mysite.model.services.OrderService;
import by.mysite.model.services.ServiceFactory;

import javax.servlet.annotation.WebServlet;

import static by.mysite.model.services.ServiceType.ORDER_SERVICE;

@WebServlet(name = "AbstractOrderController") //value - не надо, т.к. он абстрактный
public abstract class AbstractOrderController extends AbstractController {
    protected OrderService orderService;

    @Override
    public void init() {
        orderService = (OrderService) ServiceFactory.getService(ORDER_SERVICE);
    }
}
