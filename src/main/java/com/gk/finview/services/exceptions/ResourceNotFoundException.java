package main.java.com.gk.finview.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException () {
        super("Ops! O recurso solicitado não foi encontrado.");
    }
}
