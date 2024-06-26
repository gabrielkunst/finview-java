package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.controllers.UserController;
import main.java.com.gk.finview.repositories.UserRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLUserRepository;
import main.java.com.gk.finview.services.UserService;

import java.sql.Connection;

public class UserControllerFactory {
    public static UserController createUserController(Connection connection) {
        UserRepository userRepository = new MySQLUserRepository(connection);
        UserService userService = new UserService(userRepository);
        return new UserController(userService);
    }
}
