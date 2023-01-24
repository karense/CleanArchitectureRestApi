package com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity;

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

}
