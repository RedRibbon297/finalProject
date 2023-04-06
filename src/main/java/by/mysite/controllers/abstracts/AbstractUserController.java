package by.mysite.controllers.abstracts;

import by.mysite.model.services.ServiceFactory;
import by.mysite.model.services.UserService;

import javax.servlet.annotation.WebServlet;

import static by.mysite.model.services.ServiceType.USER_SERVICE;

@WebServlet(name = "AbstractUserController")
public abstract class AbstractUserController extends AbstractController {
    protected UserService userService;

    @Override
    public void init() {
        userService = (UserService) ServiceFactory.getService(USER_SERVICE);
    }
}
