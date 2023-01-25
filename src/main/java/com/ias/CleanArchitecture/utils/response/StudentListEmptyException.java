package com.ias.CleanArchitecture.utils.response;

public class StudentListEmptyException extends RuntimeException{
    public StudentListEmptyException(String message) {
        super(message);
    }
}
