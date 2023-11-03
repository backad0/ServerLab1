package com.serverlabs.serverlab1.excepcions;

public class RepositoryException extends Exception{
    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
