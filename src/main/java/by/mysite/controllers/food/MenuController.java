package by.mysite.controllers.food;

import by.mysite.controllers.abstracts.AbstractController;
import by.mysite.model.entities.food.FoodItem;
import by.mysite.model.services.FoodService;
import by.mysite.model.services.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.mysite.constants.ApplicationConstant.MENU_CONTROLLER;
import static by.mysite.constants.JspConstant.FOOD_TYPE_PARAM;
import static by.mysite.constants.JspConstant.HOME_JSP;
import static by.mysite.constants.JspConstant.PIZZA_ATTR;
import static by.mysite.constants.JspConstant.DRINK_ATTR;
import static by.mysite.model.services.ServiceType.FOOD_SERVICE;

@WebServlet(name = "MenuController", value = MENU_CONTROLLER)
public class MenuController extends AbstractController {
    private FoodService foodService;

    @Override
    public void init() {
        foodService = (FoodService) ServiceFactory.getService(FOOD_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int foodType = Integer.parseInt(req.getParameter(FOOD_TYPE_PARAM));
        List<FoodItem> items = foodService.getFoodItemByType(foodType);
        richRequest(req, foodType, items);
        forward(req, resp, HOME_JSP);
    }

    private void richRequest(HttpServletRequest req, int foodType, List<FoodItem> items) {
        switch (foodType) {
            case 1: {
                req.setAttribute(PIZZA_ATTR, items);
                break;
            }
            case 2: {
                req.setAttribute(DRINK_ATTR, items);
                break;
            }
            default: break;
        }
    }
}
