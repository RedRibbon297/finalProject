package by.mysite.constants;

public class DbConstant {
    public static final String ID_COL = "id";
    public static final String LOGIN_COL = "login";
    public static final String NAME_COL = "name";
    public static final String PASSWORD_COL = "password";
    public static final String EMAIL_COL = "email";
    public static final String PRICE_COL = "price";
    public static final String DATE_COL = "date";
    public static final String ADDRESS_COL = "address";
    public static final String QUANTITY_COL = "quantity";
    public static final String AMOUNT_COL = "amount";

    public static final String SELECT_USER_BY_CREDENTIAL =
            "SELECT id, name, email FROM user WHERE login = ? AND password = ?";

    public static final String SELECT_USER_BY_LOGIN = "SELECT id FROM user WHERE login = ?";

    public static final String INSERT_NEW_USER = "INSERT INTO user (login, name, password, email) VALUES (?,?,?,?)";
    public static final String SELECT_FOOD_ITEMS_BY_TYPE = "SELECT id, name, price FROM foodItem WHERE foodTypeId = ?";

    public static final String INSERT_ORDER = "INSERT INTO orders(id, date, userId, address) VALUES (?, ?, ?, ?)";

    public static final String INSERT_ORDER_ITEM = "INSERT INTO orderItem (orderId, itemId, quantity) VALUES (?, ?, ?)";

    public static final String SELECT_ORDERS_BY_USER =
            "SELECT id, date, address FROM orders WHERE userId = ? ORDER BY id DESC";
    //сортировка по id в обратном порядке (т.е. последний заказ будет вверху)

    public static final String SELECT_HEAD_FOR_ORDER = "SELECT date, address FROM orders WHERE id = ?";

    public static final String SELECT_ITEMS = "SELECT f.name AS name, f.price AS price, o.quantity AS quantity, (f.price*o.quantity) AS amount FROM foodItem f INNER JOIN orderItem o ON f.id = o.itemId WHERE o.orderId = ?";

    public static final String SELECT_TOTAL_AMOUNT = "SELECT SUM(amount) AS amount FROM (" + SELECT_ITEMS + ") temp";

    public static final String REMOVE_ORDER_BY_ID = "DELETE FROM orders WHERE id = ?";
}
