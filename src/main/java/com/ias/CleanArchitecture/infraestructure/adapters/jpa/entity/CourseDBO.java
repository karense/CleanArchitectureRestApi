package com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.course.CourseId;
import com.ias.CleanArchitecture.domain.model.course.CourseName;
import com.ias.CleanArchitecture.domain.model.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public CourseDBO(Course course){
        this.id = course.getId().getValue();
        this.name = course.getName().getValue();
    }

    public CourseDBO(CourseDBO courseDBO){
        this.id = courseDBO.getId();
        this.name = courseDBO.getName();
    }

    public static Course toCourse(CourseDBO courseDBO){
        if(courseDBO == null){
            return null;
        }
        return new Course(
                new CourseId(courseDBO.getId()),
                new CourseName(courseDBO.getName())
        );
    }
}
