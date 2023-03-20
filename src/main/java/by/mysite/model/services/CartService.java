package by.mysite.model.services;

import by.mysite.model.entities.order.OrderItem;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static by.mysite.constants.JspConstant.ORDER_ITEMS_ATTR;

public class CartService implements Service{

    public List<OrderItem> processCard(HttpSession session, String cartAction, OrderItem item) {
        List<OrderItem> items = !Objects.isNull(session.getAttribute(ORDER_ITEMS_ATTR))
                ? (List<OrderItem>) session.getAttribute(ORDER_ITEMS_ATTR)
                : new ArrayList<>();

        switch (cartAction) {
            case "addToCart": {
                items.add(item);
                break;
            }
            case "removeFromCart": {
                items.remove(item);
                break;
            }
            default: break;
        }
        return items;
    }
}
