package by.mysite.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.mysite.constants.ApplicationConstant.LOGIN_CONTROLLER;
import static by.mysite.constants.JspConstant.*;

@WebServlet(name = "AbstractController")

public class AbstractController extends HttpServlet {
    public void forward(HttpServletRequest req,
                        HttpServletResponse resp, String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    public void forward(HttpServletRequest req,
                        HttpServletResponse resp,
                        String url, String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_LABEL, message);
        forward(req, resp, url);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
