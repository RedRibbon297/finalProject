package by.mysite.model.entities.order;

import java.util.Date;

public class Order {
    private String id;
    private String date;
    private int userId;
    private String address;

    public Order(String id, String date, int userId, String address) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }
}
