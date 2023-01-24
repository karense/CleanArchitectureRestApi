package com.ias.CleanArchitecture.domain.model.student;

import com.ias.CleanArchitecture.domain.model.course.Course;

public class Student {

    private final StudentId id;
    private final StudentName name;
    private final StudentPhone phone;
    private final StudentEmail email;

    private final Course course;

    public Student(StudentId id, StudentName name, StudentPhone phone, StudentEmail email, Course course) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public StudentId getId() {
        return id;
    }

    public StudentName getName() {
        return name;
    }

    public StudentPhone getPhone() {
        return phone;
    }

    public StudentEmail getEmail() {
        return email;
    }
}
