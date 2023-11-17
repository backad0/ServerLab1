package com.serverlabs.serverlab1.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseEntity<T> {
    private T body;
    private int httpStatus;

    @JsonCreator
    public ResponseEntity(@JsonProperty(value = "body") T body,@JsonProperty(value = "httpStatus") int httpStatus) {
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
