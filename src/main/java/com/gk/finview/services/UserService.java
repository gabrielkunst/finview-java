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
        User userFromDB = this.userRepository.getUserByEmail(user.getEmail());

        if (userFromDB != null) {
            throw new ResourceAlreadyExistsException();
        }

        return this.userRepository.createUser(user);
    }

    public User getUserById(int id) throws ResourceNotFoundException {
        User user = this.userRepository.getUserById(id);

        if (user == null) {
            throw new ResourceNotFoundException();
        }

        return user;
    }

    public User getUserByEmail(String email) throws ResourceNotFoundException {
        User user = this.userRepository.getUserByEmail(email);

        if (user == null) {
            throw new ResourceNotFoundException();
        }

        return user;
    }

    public void deleteUserById(int id) throws ResourceNotFoundException {
        User userFromDB = this.userRepository.getUserById(id);

        if (userFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.userRepository.deleteUserById(id);
    }

    public void updateUser(User user) throws ResourceNotFoundException {
        User userFromDB = this.userRepository.getUserById(user.getId());

        if (userFromDB == null) {
            throw new ResourceNotFoundException();
        }

        this.userRepository.updateUserById(user.getId(), user);
    }
}
