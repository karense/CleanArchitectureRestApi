package com.ias.CleanArchitecture.domain.model.course;

import static org.springframework.util.Assert.notNull;

public class CourseName {

    private final String value;

    public CourseName(String value) {
        notNull(value, "Course name es requerido.");
        this.value = value;
    }

    public String getValue() {

        return value;
    }
}
