package by.mysite.model.dao;

import by.mysite.model.db.ConnectionManager;
import by.mysite.model.entities.food.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.mysite.constants.DbConstant.*;

public class FoodDao {

    public List<FoodItem> getFoodItemByType(int foodType) {
        List<FoodItem> items = new ArrayList<>();
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_FOOD_ITEMS_BY_TYPE)) {
            ps.setInt(1, foodType);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(ID_COL);
                String name = resultSet.getString((NAME_COL));
                double price = resultSet.getDouble(PRICE_COL);
                items.add(new FoodItem(id, foodType, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
