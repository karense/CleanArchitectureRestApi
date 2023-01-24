package com.ias.CleanArchitecture.infraestructure.adapters.jpa;

import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.StudentDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentAdapterRepository extends JpaRepository<StudentDBO, Integer> {
     List<StudentDBO> findByCourseId(Long id);

}
