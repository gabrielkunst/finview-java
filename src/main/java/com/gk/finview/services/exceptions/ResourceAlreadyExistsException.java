package main.java.com.gk.finview.services.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException() {
        super("Ops! O recurso já existe.");
    }
}
