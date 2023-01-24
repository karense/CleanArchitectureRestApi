package com.ias.CleanArchitecture.domain.model.course;

public class CourseId {
    private final Long value;

    public CourseId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
