package com.ias.CleanArchitecture.infraestructure.adapters.jpa;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.gateways.ICourseRepository;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.CourseDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepositoryAdapter implements ICourseRepository {

    private final ICourseAdapterRepository repository;

    public CourseRepositoryAdapter(ICourseAdapterRepository repository) {
        this.repository = repository;
    }



    @Override
    public Course courseSave(Course course) {
        CourseDBO toCourseDBO = new CourseDBO(course);
        Course toCourse = CourseDBO.toCourse(repository.save(toCourseDBO));
        return toCourse;
    }

    @Override
    public List<Course> courseGetAll() {
        List<CourseDBO> listDBO =  repository.findAll();
        List<Course> list = repository.findAll().stream().map(CourseDBO::toCourse).collect(Collectors.toList());
        return list;
    }

    @Override
    public Course courseUpdate(Course course) {
        CourseDBO toCourseDBO = new CourseDBO(course);
        Optional<CourseDBO> courseDBO = repository.findById(toCourseDBO.getId());
        if (courseDBO.isEmpty()) throw new NoSuchElementException("El curso que intenta actualizar no existe.") ;

        Course toCourse = CourseDBO.toCourse(repository.save(toCourseDBO));
        return toCourse;
    }

    @Override
    public Course courseById(Long id) {
        Optional<CourseDBO> value = repository.findById(id);
        if(value.isEmpty()) throw new NoSuchElementException("El curso con id = "+id+" no existe.");
        return CourseDBO.toCourse(value.get());
    }
}
