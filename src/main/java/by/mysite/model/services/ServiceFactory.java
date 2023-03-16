package by.mysite.model.services;

import java.util.HashMap;
import java.util.Map;

import static by.mysite.model.services.ServiceType.*;

public class ServiceFactory {
    private static Map<ServiceType, Service> services;

    public static void init() {
        services = new HashMap<>();
        services.put(CART_SERVICE, new CartService());
        services.put(FOOD_SERVICE, new FoodService());
        services.put(ORDER_SERVICE, new OrderService());
        services.put(USER_SERVICE, new UserService());
    }

    public static Service getService(ServiceType type){
        return services.get(type);
    }
}
