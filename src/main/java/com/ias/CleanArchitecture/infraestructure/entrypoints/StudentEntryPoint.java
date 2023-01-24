package com.ias.CleanArchitecture.infraestructure.entrypoints;

import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.model.student.dto.StudentDTO;
import com.ias.CleanArchitecture.domain.usecase.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentEntryPoint {

    private final StudentUseCase studentUseCase;

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO studentDTO){
        return studentUseCase.saveStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> getAll(){
        return studentUseCase.getAll();
    }

    @PutMapping
    public StudentDTO update(@RequestBody StudentDTO studentDTO){
        return studentUseCase.update(studentDTO);
    }
}
