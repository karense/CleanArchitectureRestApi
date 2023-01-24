package com.ias.CleanArchitecture.infraestructure.adapters.jpa;

import com.ias.CleanArchitecture.domain.model.gateways.ICourseRepository;
import com.ias.CleanArchitecture.domain.model.gateways.IStudentRepository;
import com.ias.CleanArchitecture.domain.model.student.Student;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.CourseDBO;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.StudentDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryAdapter implements IStudentRepository {

    private final IStudentAdapterRepository repository;
    private final ICourseAdapterRepository courseRepository;

    public StudentRepositoryAdapter(IStudentAdapterRepository repository, ICourseAdapterRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Student studentSave(Student student) {
        StudentDBO toDBO = new StudentDBO(student);
        Optional<CourseDBO> courseDBO = courseRepository.findById(toDBO.getCourse().getId());
        if (courseDBO.isEmpty()) throw new NoSuchElementException("El curso al que desea agregar al estudiante no exite.");
        Student toStudent = StudentDBO.toStudent(repository.save(toDBO));
        return toStudent;
    }

    @Override
    public Student update(Student student) {
        StudentDBO toDBO = new StudentDBO(student);
        Optional<StudentDBO> studentDBO = repository.findById(toDBO.getId());

        if (studentDBO.isEmpty()) throw new NoSuchElementException("El estudiante que intenta actualizar no existe.");
        Student toStudent = StudentDBO.toStudent(repository.save(toDBO));
        return toStudent;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = repository.findAll().stream().map(StudentDBO::toStudent).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<Student> getByCourse(Long id) {
        List<StudentDBO> list = repository.findByCourseId(id);
        return list.stream().map(StudentDBO::toStudent).collect(Collectors.toList());
    }
}
