package by.mysite.controllers.order;

import by.mysite.constants.ApplicationConstant;
import by.mysite.constants.JspConstant;
import by.mysite.controllers.abstracts.AbstractController;
import by.mysite.model.entities.food.FoodItem;
import by.mysite.model.entities.order.OrderItem;
import by.mysite.model.services.CartService;
import by.mysite.model.services.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static by.mysite.model.services.ServiceType.CART_SERVICE;

@WebServlet(name = " CartController", value = ApplicationConstant.CART_CONTROLLER)
public class CartController extends AbstractController {
    private CartService cartService;

    @Override
    public void init() {
        cartService = (CartService) ServiceFactory.getService(CART_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(JspConstant.FOOD_ID_PARAM));
        int foodType = Integer.parseInt(req.getParameter(JspConstant.FOOD_TYPE_PARAM));
        String foodName = req.getParameter(JspConstant.FOOD_NAME_PARAM);
        double price = Double.parseDouble(req.getParameter(JspConstant.FOOD_PRICE_PARAM));
        int quantity = Integer.parseInt(req.getParameter(JspConstant.FOOD_QUANTITY_PARAM));
        String cartAction = req.getParameter(JspConstant.CART_ACTION_PARAM);

        OrderItem item = new OrderItem(new FoodItem(id, foodType, foodName, price), quantity);

        HttpSession session = req.getSession();

        List<OrderItem> items = cartService.processCard(session, cartAction, item);

        session.setAttribute(JspConstant.ORDER_ITEMS_ATTR, items);

        if ("addToCart".equals(cartAction)) {
            redirectToMenuPage(resp, foodType);
        } else {
            redirect(resp, JspConstant.CART_JSP);
        }
    }

    private void redirectToMenuPage(HttpServletResponse resp, int foodType) throws ServletException, IOException {
        switch (foodType) {
            case 1: {
                redirect(resp, ApplicationConstant.PIZZAS_MENU);
                break;
            }
            case 2: {
                redirect(resp, ApplicationConstant.DRINKS_MENU);
                break;
            }
            default: {
                redirect(resp, JspConstant.HOME_JSP);
                break;
            }
        }
    }
}
