package by.mysite.controllers.user;

import by.mysite.controllers.AbstractController;
import by.mysite.model.services.UserService;
import by.mysite.model.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.mysite.constants.ApplicationConstant.ERROR_MESSAGE;
import static by.mysite.constants.ApplicationConstant.LOGIN_CONTROLLER;
import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "AuthorizationController", value = LOGIN_CONTROLLER)

public class AuthorizationController extends AbstractController {
    private static UserService userService;

    @Override
    public void init() throws ServletException {
        UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_LABEL);
        String password = req.getParameter(PASSWORD_LABEL);

        User user = userService.getUser(login, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute(USER_LABEL, user);
            forward(req, resp, USER_JSP);
        } else {
            req.setAttribute(MESSAGE_LABEL, ERROR_MESSAGE);
            forward(req, resp, LOGIN_JSP, MESSAGE_LABEL );
        }

    }

}
