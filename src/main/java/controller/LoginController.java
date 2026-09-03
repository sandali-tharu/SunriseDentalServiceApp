package controller;

import com.mycompany.sunrisedentalserviceapp.dao.UserDAO;
import com.mycompany.sunrisedentalserviceapp.model.User;

public class LoginController {

    private final UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return null;
        }
        return userDAO.authenticateUser(username, password);
    }
}