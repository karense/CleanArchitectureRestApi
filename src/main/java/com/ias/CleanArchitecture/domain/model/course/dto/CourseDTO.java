package com.ias.CleanArchitecture.domain.model.course.dto;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.course.CourseId;
import com.ias.CleanArchitecture.domain.model.course.CourseName;
import com.ias.CleanArchitecture.domain.model.student.Student;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseDTO {
    private Long id;
    @NotEmpty(message = "[name] es requerido.")
    private String name;


    public CourseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseDTO(Course course) {
        this.id = course.getId().getValue();
        this.name = course.getName().getValue();
    }

    public static Course toCourse(CourseDTO courseDTO){
            return new Course(
                    new CourseId(courseDTO.getId()),
                    new CourseName(courseDTO.getName())
            );

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
