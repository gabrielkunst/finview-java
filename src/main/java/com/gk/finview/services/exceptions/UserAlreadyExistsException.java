package main.java.com.gk.finview.services.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("Ops! Já existe um usuário com o email fornecido.");
    }
}
