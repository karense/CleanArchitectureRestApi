package com.ias.CleanArchitecture.infraestructure.entrypoint;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@WebMvcTest(CourseEntryPoint.class)
public class CourseEntryPointTest {

    @MockBean
    private CourseUseCase courseUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Save course - created 201")
    void saveCourse() throws Exception {
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        Mockito.when(courseUseCase.saveCourse(Mockito.any(CourseDTO.class)))
                .thenReturn(courseDTO);
        ObjectMapper mapper = new ObjectMapper();

        Mockito
                .when(courseUseCase
                        .saveCourse(Mockito.any(CourseDTO.class)))
                .thenReturn(courseDTO);
        //Actions and Asserts
        mockMvc.perform(MockMvcRequestBuilders.post("/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(courseDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Get all course success")
    void getAll() throws Exception {
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        List<CourseDTO> list = new ArrayList<>();
        list.add(courseDTO);

        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(courseUseCase.getAll()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(list)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Get all course is empty")
    void getAllEmpty() throws Exception {
        List<CourseDTO> courseDTOList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(courseUseCase.getAll()).thenReturn(courseDTOList);

        mockMvc.perform(MockMvcRequestBuilders.get("/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(courseDTOList)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Update course success")
    void updateCourse() throws Exception {
        CourseDTO courseDTO = new CourseDTO(1L, "Math");

        Mockito.when(courseUseCase.update(Mockito.any(CourseDTO.class))).thenReturn(courseDTO);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.put("/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(courseDTO))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Update course by id no found")
    void updateCourseNotCreated(){
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        // Mockito.when(courseUseCase.update(Mockito.any(CourseDTO.class))).thenReturn(throw new NoSuchElementException(""));
    }



}
