package com.ias.CleanArchitecture.domain.model.student;

public class StudentId {
    private final Integer value;

    public StudentId(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
