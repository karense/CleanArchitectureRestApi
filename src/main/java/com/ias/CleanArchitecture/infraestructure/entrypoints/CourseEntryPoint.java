package com.ias.CleanArchitecture.infraestructure.entrypoints;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.usecase.CourseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@AllArgsConstructor
public class CourseEntryPoint {

    private final CourseUseCase courseUseCase;

    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody CourseDTO courseDTO){
        return new ResponseEntity<>(courseUseCase.saveCourse(courseDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        CourseDTO courseDTO = courseUseCase.getById(id);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<CourseDTO> list = courseUseCase.getAll();
        if (list.isEmpty()) return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



    @PutMapping
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO){
        return courseUseCase.update(courseDTO);
    }
}
