package by.mysite.controllers.user;

import by.mysite.controllers.AbstractController;
import by.mysite.model.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.mysite.constants.ApplicationConstant.LOGIN_CONTROLLER;
import static by.mysite.constants.ApplicationConstant.REGISTRATION_CONTROLLER;
import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "RegistrationController", value = REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_LABEL);
        String name = req.getParameter(NAME_LABEL);
        String password = req.getParameter(PASSWORD_LABEL);
        String email = req.getParameter(EMAIL_LABEL);

        User user = new User(login, name, email);



    }
}
