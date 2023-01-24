package com.ias.CleanArchitecture.domain.model.gateways;

import com.ias.CleanArchitecture.domain.model.student.Student;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;

import java.util.List;

public interface IStudentRepository {
     Student studentSave(Student student);
     Student update(Student student);
     List<Student> getAll();

     List<Student> getByCourse(Long id);

}
