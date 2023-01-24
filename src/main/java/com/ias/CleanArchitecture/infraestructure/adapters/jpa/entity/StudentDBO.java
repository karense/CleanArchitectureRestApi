package com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity;

import com.ias.CleanArchitecture.domain.model.student.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private CourseDBO courseDBO;

    public StudentDBO(Student student){
        this.id = student.getId().getValue();
        this.name = student.getName().getValue();
        this.email = student.getEmail().getValue();
        this.phone = student.getPhone().getValue();
    }

    public static Student toStudent(StudentDBO studentDBO){
        return new Student(
                new StudentId(studentDBO.getId()),
                new StudentName(studentDBO.getName()),
                new StudentPhone(studentDBO.getPhone()),
                new StudentEmail(studentDBO.getEmail())
        );
    }
}
