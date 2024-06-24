package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.repositories.UserRepository;
import main.java.com.gk.finview.services.exceptions.UserAlreadyExistsException;
import main.java.com.gk.finview.services.exceptions.UserNotFoundException;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) throws UserAlreadyExistsException {
        User userFromDB = this.userRepository.getUserById(user.getId());

        if (userFromDB != null) {
            throw new UserAlreadyExistsException();
        }

        return this.userRepository.createUser(user);
    }

    public User getUserById(int id) throws UserNotFoundException {
        User userFromDB = this.userRepository.getUserById(id);

        if (userFromDB == null) {
            throw new UserNotFoundException();
        }

        return userFromDB;
    }

    public User deleteUserById(int id) throws UserNotFoundException {
        this.getUserById(id);

        return this.userRepository.deleteUserById(id);
    }

    public User updateUser(User user) throws UserNotFoundException {
        this.getUserById(user.getId());

        return this.userRepository.updateUser(user);
    }
}
