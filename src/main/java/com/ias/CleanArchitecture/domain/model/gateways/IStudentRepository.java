package com.ias.CleanArchitecture.domain.model.gateways;

import com.ias.CleanArchitecture.domain.model.student.Student;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;

import java.util.List;

public interface IStudentRepository {
    public Student studentSave(Student student);
    public Student update(Student student);
    public List<Student> getAll();
}
