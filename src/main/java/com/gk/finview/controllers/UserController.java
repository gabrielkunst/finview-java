package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.services.UserService;
import main.java.com.gk.finview.services.exceptions.ResourceAlreadyExistsException;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    public void createUser (User user) {
        try {
            this.userService.createUser(user);
        } catch (Exception error) {
            if (error instanceof ResourceAlreadyExistsException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao criar o usuário." + error.getMessage());
        }
    }

    public void updateUser (User user) {
        try {
            this.userService.updateUser(user);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao atualizar o usuário." + error.getMessage());
        }
    }

    public User getUserById (int id) {
        try {
            return this.userService.getUserById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar o usuário." + error.getMessage());
        }
    }

    public User getUserByEmail (String email) {
        try {
            return this.userService.getUserByEmail(email);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao buscar o usuário." + error.getMessage());
        }
    }

    public void deleteUserById (int id) {
        try {
            this.userService.deleteUserById(id);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException(error.getMessage());
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao deletar o usuário." + error.getMessage());
        }
    }
}
