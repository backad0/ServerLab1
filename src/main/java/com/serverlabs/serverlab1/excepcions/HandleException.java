package com.serverlabs.serverlab1.excepcions;

public class HandleException extends Exception{

    public HandleException(String message) {
        super(message);
    }

    public HandleException(String message, Throwable cause) {
        super(message, cause);
    }
}
