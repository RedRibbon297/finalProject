package by.mysite.listener;

import by.mysite.model.db.ConnectionManager;
import by.mysite.model.services.ServiceFactory;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public class InitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        ConnectionManager.init();
        ServiceFactory.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }
}
