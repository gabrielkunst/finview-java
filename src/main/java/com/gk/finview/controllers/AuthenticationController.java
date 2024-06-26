package main.java.com.gk.finview.controllers;

import main.java.com.gk.finview.models.Address;
import main.java.com.gk.finview.models.User;
import main.java.com.gk.finview.services.AuthenticationService;
import main.java.com.gk.finview.services.exceptions.ResourceAlreadyExistsException;
import main.java.com.gk.finview.services.exceptions.ResourceNotFoundException;

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public User register(User user, Address address) {
        try {
            return this.authenticationService.register(user, address);
        } catch (Exception error) {
            if (error instanceof ResourceAlreadyExistsException) {
                throw new RuntimeException("Ops! O e-mail informado já está em uso.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao registrar o usuário.");
        }
    }

    public User login(String email, String password) {
        try {
            return this.authenticationService.login(email, password);
        } catch (Exception error) {
            if (error instanceof ResourceNotFoundException) {
                throw new RuntimeException("Ops! Usuário não encontrado.");
            }

            throw new RuntimeException("Ops! Ocorreu um erro ao realizar o login.");
        }
    }
}
