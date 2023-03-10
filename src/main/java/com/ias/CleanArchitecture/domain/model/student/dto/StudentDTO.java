package com.ias.CleanArchitecture.domain.model.student.dto;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.model.student.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class StudentDTO {
    private Integer id;
    @NotEmpty(message = "[name] es requerido.")
    private String name;
    private String phone;
    @Email(message = "[email] no es un email valido.")
    private String email;

    @NotBlank(message = "[course_id] es requerido.")
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
        this.course = new CourseDTO(student.getCourse());
    }

    public static Student toStudent(StudentDTO studentDTO){
       return new Student(
               new StudentId(studentDTO.getId()),
               new StudentName(studentDTO.getName()),
               new StudentPhone(studentDTO.getPhone()),
               new StudentEmail(studentDTO.getEmail()),
               CourseDTO.toCourse(studentDTO.getCourse()));
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
