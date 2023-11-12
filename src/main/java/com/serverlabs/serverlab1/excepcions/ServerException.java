package com.serverlabs.serverlab1.excepcions;

public class ServerException extends Exception{
    public ServerException(String massage){
        super(massage);
    }

    public ServerException(String massage, Throwable course){
        super(massage, course);
    }
}
