package com.ias.CleanArchitecture.domain.model.student;

public class StudentName {
    private final String value;

    public StudentName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
