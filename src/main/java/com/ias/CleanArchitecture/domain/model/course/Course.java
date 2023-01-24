package com.ias.CleanArchitecture.domain.model.course;

import com.ias.CleanArchitecture.domain.model.student.Student;

import java.util.List;

public class Course {
    private final CourseId id;
    private final CourseName name;


    public Course(CourseId id, CourseName name) {
        this.id = id;
        this.name = name;
    }


    public CourseId getId() {
        return id;
    }

    public CourseName getName() {
        return name;
    }
}
