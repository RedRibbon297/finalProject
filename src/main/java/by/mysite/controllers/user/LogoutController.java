package by.mysite.controllers.user;

import by.mysite.controllers.abstracts.AbstractUserController;
import by.mysite.model.entities.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static by.mysite.constants.ApplicationConstant.LOGOUT_CONTROLLER;
import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "LogoutController", value = LOGOUT_CONTROLLER)

public class LogoutController extends AbstractUserController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(USER_ATTR);
        if (user != null) {
            session.invalidate();
        }
        redirect(resp, INDEX_JSP);
    }
}
