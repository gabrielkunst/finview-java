package main.java.com.gk.finview.services.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Ops! Usuário não encontrado.");
    }
}
