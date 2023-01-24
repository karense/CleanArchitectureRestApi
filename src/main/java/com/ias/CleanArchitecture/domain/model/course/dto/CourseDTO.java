package com.ias.CleanArchitecture.domain.model.course.dto;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.course.CourseId;
import com.ias.CleanArchitecture.domain.model.course.CourseName;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;

import java.util.List;

public class CourseDTO {
    private Long id;
    private String name;

    private List<StudentDTO> studentList;

    public CourseDTO(Long id, String name, List<StudentDTO> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
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

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }
}
