package com.ias.CleanArchitecture.domain.usecase;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.model.gateways.IStudentRepository;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentUseCase {

    private final IStudentRepository repository;

    public StudentUseCase(IStudentRepository repository) {
        this.repository = repository;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO){
        StudentDTO toDTO = new StudentDTO(repository.studentSave(StudentDTO.toStudent(studentDTO)));
        return toDTO;
    }

    public List<StudentDTO> getAll(){
        List<StudentDTO> list = repository.getAll().stream().map(StudentDTO::new).collect(Collectors.toList());
        return list;
    }

    public StudentDTO update(StudentDTO studentDTO){
        StudentDTO toDTO = new StudentDTO(repository.update(StudentDTO.toStudent(studentDTO)));
        return toDTO;
    }

    public List<StudentDTO> getByCourse(Long idCourse){
        return repository.getByCourse(idCourse).stream().map(StudentDTO::new).collect(Collectors.toList());
    }
}
