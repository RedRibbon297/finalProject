package by.mysite.model.services;

import by.mysite.model.dao.FoodDao;
import by.mysite.model.entities.food.FoodItem;

import java.util.List;

public class FoodService implements Service {

    private FoodDao dao;

    public FoodService() {
        dao = new FoodDao();
    }

    public List<FoodItem> getFoodItemByType(int foodType) {
        return dao.getFoodItemByType(foodType);
    }
}
