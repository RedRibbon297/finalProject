package by.mysite.model.dao;

import by.mysite.model.db.ConnectionManager;
import by.mysite.model.users.User;

public class UserDao {
    private static UserDao dao;

    public UserDao() {
        ConnectionManager.init();
    }

    public static UserDao getInstance() {
        return dao == null ? new UserDao() : dao;
    }

    public User getUser(String login, String password){
        return null;
    }
}
