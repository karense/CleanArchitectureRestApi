package com.ias.CleanArchitecture.domain.model.student.dto;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.model.student.*;

public class StudentDTO {
    private Integer id;
    private String name;
    private String phone;
    private String email;

    private CourseDTO course;

    public StudentDTO(Integer id, String name, String phone, String email, CourseDTO course) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.course = course;
    }

    public StudentDTO(Student student) {
        this.id = student.getId().getValue();
        this.name = student.getName().getValue();
        this.phone = student.getPhone().getValue();
        this.email = student.getEmail().getValue();
    }

    public static Student toStudent(StudentDTO studentDTO){
       return new Student(
               new StudentId(studentDTO.getId()),
               new StudentName(studentDTO.getName()),
               new StudentPhone(studentDTO.getPhone()),
               new StudentEmail(studentDTO.getEmail())
       );
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
