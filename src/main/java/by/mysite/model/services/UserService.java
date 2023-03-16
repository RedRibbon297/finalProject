package by.mysite.model.services;

import by.mysite.model.dao.UserDao;
import by.mysite.model.entities.users.User;

public class UserService implements Service {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User getUser(String login, String password) {
        return userDao.getUser(login, password);
    }

    public boolean addUser(User user, String password) {
        return userDao.addUser(user, password);
    }
}
