package main.java.com.gk.finview.factories;

import main.java.com.gk.finview.repositories.UserRepository;
import main.java.com.gk.finview.repositories.inMemory.InMemoryUserRepository;
import main.java.com.gk.finview.services.UserService;

public class UserServiceFactory {
    private final UserRepository userRepository;

    public UserServiceFactory () {
        this.userRepository = new InMemoryUserRepository();
    }

    public UserService createUserService() {
        return new UserService(userRepository);
    }
}
