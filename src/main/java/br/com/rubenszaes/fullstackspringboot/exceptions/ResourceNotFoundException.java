package br.com.rubenszaes.fullstackspringboot.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Resource Not Found With id = " + id);
    }
}
