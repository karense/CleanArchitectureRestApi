package com.ias.CleanArchitecture.utils.response;

import org.springframework.validation.BindingResult;

public class InvalidDataException extends RuntimeException{
    private final BindingResult errors;

    public InvalidDataException(BindingResult errors) {
        super();
        this.errors = errors;
    }

    public InvalidDataException(String message, BindingResult errors) {
        super(message);
        this.errors = errors;
    }

    public BindingResult getErrors() {
        return errors;
    }
}
