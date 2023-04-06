package by.mysite.model.services;

import by.mysite.model.dao.OrderDao;
import by.mysite.model.entities.order.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderService implements Service {

    private OrderDao dao;

    public OrderService() {
        dao = new OrderDao();
    }

    public boolean saveOrder(HttpSession session, String address) {
        return dao.saveOrder(session, address);
    }

    public List<Order> getOrdersList(int userId) {
        return dao.getOrdersList(userId);
    }

    public String getReceipt(String orderId) {
        return dao.getReceipt(orderId);
    }

    public void removeOrderById(String orderId) {
        dao.removeOrderById(orderId);
    }
}
