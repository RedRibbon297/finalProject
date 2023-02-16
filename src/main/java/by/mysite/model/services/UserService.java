package by.mysite.model.services;

import by.mysite.model.dao.UserDao;
import by.mysite.model.users.User;

public class UserService {
    private static UserService service;
    private UserDao userDao;

    public UserService() {
        userDao = UserDao.getInstance();
    }

    public User getUser(String login, String password) {
        //return userDao.getUser(login, password);
        return new User(1, "Name", "Pass");
    }

    public static UserService getInstance() {
        return service == null ? new UserService() : service;
    }


}
