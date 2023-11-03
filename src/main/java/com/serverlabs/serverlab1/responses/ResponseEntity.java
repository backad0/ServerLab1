package com.serverlabs.serverlab1.responses;

public class ResponseEntity<T> {
    private T body;
    private int httpStatus;

    public ResponseEntity(T body, int httpStatus) {
        this.body = body;
        this.httpStatus = httpStatus;
    }

    public T getBody() {
        return body;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
