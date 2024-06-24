package main.java.com.gk.finview.services;

import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.repositories.UserRepository;
import main.java.com.gk.finview.services.exceptions.ResourceAlreadyExistsException;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) throws ResourceAlreadyExistsException {
        User userFromDB = this.userRepository.getUserById(user.getId());

        if (userFromDB != null) {
            throw new ResourceAlreadyExistsException();
        }

        return this.userRepository.createUser(user);
    }

    public User getUserById(int id) throws ResourceNotFoundException {
        User userFromDB = this.userRepository.getUserById(id);

        if (userFromDB == null) {
            throw new ResourceNotFoundException();
        }

        return userFromDB;
    }

    public User deleteUserById(int id) throws ResourceNotFoundException {
        this.getUserById(id);

        return this.userRepository.deleteUserById(id);
    }

    public User updateUser(User user) throws ResourceNotFoundException {
        this.getUserById(user.getId());

        return this.userRepository.updateUser(user);
    }
}
