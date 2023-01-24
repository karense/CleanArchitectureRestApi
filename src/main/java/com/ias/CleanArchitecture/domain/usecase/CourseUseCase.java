package com.ias.CleanArchitecture.domain.usecase;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.model.gateways.ICourseRepository;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.CourseDBO;

import java.util.List;
import java.util.stream.Collectors;

public class CourseUseCase {

    private final ICourseRepository repository;


    public CourseUseCase(ICourseRepository repository) {
        this.repository = repository;
    }

    public CourseDTO saveCourse(CourseDTO courseDTO){
        CourseDTO toDTO = new CourseDTO(repository.courseSave(CourseDTO.toCourse(courseDTO)));
        return toDTO;
    }

    public List<CourseDTO> getAll(){
        List<CourseDTO> list = repository.courseGetAll().stream().map(CourseDTO::new).collect(Collectors.toList());
        return list;
    }

    public CourseDTO update(CourseDTO courseDTO){
        CourseDTO toDTO = new CourseDTO(repository.courseUpdate(CourseDTO.toCourse(courseDTO)));
        return toDTO;
    }
}
