package com.ias.CleanArchitecture.domain.model.gateways;

import com.ias.CleanArchitecture.domain.model.student.Student;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;

public interface IStudentRepository {
    public Student studentSave(Student student);
}
