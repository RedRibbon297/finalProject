package by.mysite.controllers.abstracts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "AbstractController")

public abstract class AbstractController extends HttpServlet {

    protected void forward(HttpServletRequest req,
                           HttpServletResponse resp, String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    protected void forward(HttpServletRequest req,
                           HttpServletResponse resp,
                           String url, String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR, message);
        forward(req, resp, url);
    }

    protected void redirect(HttpServletResponse resp, String url) throws ServletException, IOException {
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
