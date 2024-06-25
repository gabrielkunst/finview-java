package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.UserRepository;
import main.java.com.gk.finview.repositories.mySQL.MySQLUserRepository;
import main.java.com.gk.finview.services.UserService;

import java.sql.Connection;

public class UserServiceFactory {
    private final Connection connection;

    public UserServiceFactory(Connection connection) {
        this.connection = connection;
    }

    public UserService createUserService() {
        UserRepository userRepository = new MySQLUserRepository(connection);
        return new UserService(userRepository);
    }
}
