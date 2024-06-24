package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.factories.UserServiceFactory;
import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.services.UserService;
import main.java.com.gk.finview.services.exceptions.UserAlreadyExistsException;
import main.java.com.gk.finview.services.exceptions.UserNotFoundException;

public class UserController {
    private final UserService userService;

    public UserController () {
        UserServiceFactory userServiceFactory = new UserServiceFactory();
        this.userService = userServiceFactory.createUserService();
    }

    public User createUser (User user) {
        try {
            return this.userService.createUser(user);
        } catch (Exception error) {
            if (error instanceof  UserAlreadyExistsException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao criar o usuário.");
        }
    }

    public User updateUser (User user) {
        try {
            return this.userService.updateUser(user);
        } catch (Exception error) {
            if (error instanceof UserNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao atualizar o usuário.");
        }
    }

    public User getUserById (int id) {
        try {
            return this.userService.getUserById(id);
        } catch (Exception error) {
            if (error instanceof UserNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar o usuário.");
        }
    }

    public User deleteUserById (int id) {
        try {
            return this.userService.deleteUserById(id);
        } catch (Exception error) {
            if (error instanceof UserNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao deletar o usuário.");
        }
    }
}
