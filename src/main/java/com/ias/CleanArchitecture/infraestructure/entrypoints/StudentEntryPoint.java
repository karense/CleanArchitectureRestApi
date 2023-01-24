package com.ias.CleanArchitecture.infraestructure.entrypoints;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;
import com.ias.CleanArchitecture.domain.usecase.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentEntryPoint {

    private final StudentUseCase studentUseCase;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentUseCase.saveStudent(studentDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<StudentDTO> list = studentUseCase.getAll();
        if(list.isEmpty())  return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> getByCourse(@PathVariable(name = "id") Long id){
        List<StudentDTO> list = studentUseCase.getByCourse(id);
        if(list.isEmpty()) return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping
    public StudentDTO update(@RequestBody StudentDTO studentDTO){
        return studentUseCase.update(studentDTO);
    }
}
