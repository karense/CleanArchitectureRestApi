package com.ias.CleanArchitecture.infraestructure.adapters.jpa;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.gateways.ICourseRepository;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.CourseDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        List<Course> list = repository.findAll().stream().map(CourseDBO::toCourse).collect(Collectors.toList());
        return list;
    }

    @Override
    public Course courseUpdate(Course course) {
        CourseDBO toCourseDBO = new CourseDBO(course);
        Course toCourse = CourseDBO.toCourse(repository.save(toCourseDBO));
        return toCourse;
    }

    @Override
    public Course courseById(long id) {
        Optional<CourseDBO> value = repository.findById(id);

        if(value.isEmpty()){

        }
        return CourseDBO.toCourse(value.get());
    }
}
