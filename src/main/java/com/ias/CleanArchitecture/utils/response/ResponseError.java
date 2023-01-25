package com.ias.CleanArchitecture.utils.response;

import org.springframework.validation.BindingResult;

import java.util.List;

public class ResponseError {
    private Integer status;
    private String message;


    private List<String> errors;

    public ResponseError(String message, Integer status, List<String> errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
