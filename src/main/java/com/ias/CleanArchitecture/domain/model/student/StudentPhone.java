package com.ias.CleanArchitecture.domain.model.student;

public class StudentPhone {
    private final String value;

    public StudentPhone(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
