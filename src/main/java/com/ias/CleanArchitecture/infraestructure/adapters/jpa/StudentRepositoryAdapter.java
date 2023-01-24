package com.ias.CleanArchitecture.infraestructure.adapters.jpa;

import com.ias.CleanArchitecture.domain.model.gateways.IStudentRepository;
import com.ias.CleanArchitecture.domain.model.student.Student;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.StudentDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryAdapter implements IStudentRepository {

    private final IStudentAdapterRepository repository;

    public StudentRepositoryAdapter(IStudentAdapterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student studentSave(Student student) {
        StudentDBO toDBO = new StudentDBO(student);
        Student toStudent = StudentDBO.toStudent(repository.save(toDBO));
        return toStudent;
    }

    @Override
    public Student update(Student student) {
        StudentDBO toDBO = new StudentDBO(student);
        Student toStudent = StudentDBO.toStudent(repository.save(toDBO));
        return toStudent;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = repository.findAll().stream().map(StudentDBO::toStudent).collect(Collectors.toList());
        return list;
    }
}
