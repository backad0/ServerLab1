package com.serverlabs.serverlab1.responses;

import java.util.List;

public class CommonResponse<T> {
    private boolean isOk;
    private int errorCode;
    private String errorMassage;
    private List<String> errors;
    private T data;

    public CommonResponse(T data) {
        this.data = data;
        isOk = true;
        errorCode = 0;
        errorMassage = null;
        errors = null;
    }

    public CommonResponse(int errorCode, String errorMassage){
        data = null;
        isOk = false;
        this.errorCode = errorCode;
        this.errorMassage = errorMassage;
        this.errors = null;
    }

    public CommonResponse(int errorCode, String errorMassage, List<String> errors) {
        this.errorCode = errorCode;
        this.errorMassage = errorMassage;
        this.errors = errors;
        data = null;
        isOk = false;
    }

    public boolean isOk() {
        return isOk;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMassage() {
        return errorMassage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }
}
