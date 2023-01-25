package com.ias.CleanArchitecture.infraestructure.entrypoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.usecase.CourseUseCase;
import com.ias.CleanArchitecture.infraestructure.entrypoints.CourseEntryPoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(CourseEntryPoint.class)
public class CourseEntryPointTest {

    @MockBean
    private CourseUseCase courseUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Save course ok")
    void saveCourse(){
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        Mockito.when(courseUseCase.saveCourse(Mockito.any(CourseDTO.class)))
                .thenReturn(courseDTO);
        ObjectMapper mapper = new ObjectMapper();


    }
}
