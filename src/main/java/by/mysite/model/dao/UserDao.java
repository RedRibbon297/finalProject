package by.mysite.model.dao;

import by.mysite.model.db.ConnectionManager;
import by.mysite.model.entities.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.mysite.constants.DbConstant.*;

public class UserDao {

    public User getUser(String login, String password) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_CREDENTIAL)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(ID_COL);
                String name = rs.getString(NAME_COL);
                String email = rs.getString(EMAIL_COL);
                return new User(id, login, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user, String password) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(INSERT_NEW_USER)) {
            if (isAccessible(user.getLogin())) {
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getName());
                ps.setString(3, password);
                ps.setString(4, user.getEmail());
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isAccessible(String login) throws SQLException {
        Connection cn = ConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_LOGIN);
        ps.setString(1, login);
        return !ps.executeQuery().next();
    }
}
