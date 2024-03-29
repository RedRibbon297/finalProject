package by.mysite.controllers.user;

import by.mysite.controllers.abstracts.AbstractUserController;
import by.mysite.model.entities.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.mysite.constants.ApplicationConstant.LOGIN_CONTROLLER;
import static by.mysite.constants.ApplicationConstant.USER_NOT_REGISTERED_MESSAGE;
import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "AuthorizationController", value = LOGIN_CONTROLLER)

public class AuthorizationController extends AbstractUserController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_LABEL);
        String password = req.getParameter(PASSWORD_LABEL);

        User user = userService.getUser(login, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute(USER_ATTR, user);
            forward(req, resp, HOME_JSP);
        } else {
            forward(req, resp, LOGIN_JSP, USER_NOT_REGISTERED_MESSAGE);
        }
    }
}
