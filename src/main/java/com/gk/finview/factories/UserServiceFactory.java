package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.UserRepository;
import main.java.com.gk.finview.repositories.inMemory.InMemoryUserRepository;
import main.java.com.gk.finview.services.UserService;

public class UserServiceFactory {
    public static UserService createUserService() {
        UserRepository userRepository = new InMemoryUserRepository();
        return new UserService(userRepository);
    }
}
