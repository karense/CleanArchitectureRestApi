package com.ias.CleanArchitecture.infraestructure.entrypoints;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.usecase.CourseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@AllArgsConstructor
public class CourseEntryPoint {

    private final CourseUseCase courseUseCase;

    @PostMapping
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO){
        return courseUseCase.saveCourse(courseDTO);
    }

    @GetMapping
    public List<CourseDTO> getAll(){
        return courseUseCase.getAll();
    }

    @PutMapping
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO){
        return courseUseCase.update(courseDTO);
    }
}
