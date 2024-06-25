package main.java.com.gk.finview;

import main.java.com.gk.finview.controllers.UserController;
import main.java.com.gk.finview.factories.UserServiceFactory;
import main.java.com.gk.finview.lib.DB;
import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.services.UserService;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection connection = DB.getConnection();
            System.out.println("DB CONNECTED");

            UserServiceFactory userServiceFactory = new UserServiceFactory(connection);
            UserService userService = userServiceFactory.createUserService();
            UserController userController = new UserController(userService);

            User user = userController.getUserByEmail("root@gmail.com");

            System.out.println("FETCHED USER: " + user);

            user.setName("Root Teste Update");

            userController.updateUser(user);

            connection.close();
            System.out.println("DB CLOSED");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}