package com.ias.CleanArchitecture.domain.usecase;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;
import com.ias.CleanArchitecture.domain.model.gateways.ICourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CourseUseCaseTest {

    @Mock
    private ICourseRepository iCourseRepository;
    @InjectMocks
    private CourseUseCase courseUseCase;

    @Test
    void saveCourse() {
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        Course course = CourseDTO.toCourse(courseDTO);
        when(iCourseRepository.courseSave(any(Course.class))).thenReturn(course);

        CourseDTO answer = courseUseCase.saveCourse(courseDTO);

        assertNotNull(answer);
        assertEquals(answer.getName(), courseDTO.getName());
    }

    @Test
    void getAll(){
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        Course course = CourseDTO.toCourse(courseDTO);

        List<Course> courseList = new ArrayList<>();
        courseList.add(course);

        when(iCourseRepository.courseGetAll()).thenReturn(courseList);

        List<CourseDTO> res = iCourseRepository.courseGetAll().stream().map(CourseDTO::new).collect(Collectors.toList());

        assertNotNull(res);
        assertTrue(res.size() > 0);

    }

    @Test
    void getById(){
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        Course course = CourseDTO.toCourse(courseDTO);

        when(iCourseRepository.courseById(courseDTO.getId())).thenReturn(course);

        Course res = iCourseRepository.courseById(courseDTO.getId());

        assertNotNull(res);
        assertTrue(res.getId().equals(courseDTO.getId()));
    }

    @Test
    void update(){
        CourseDTO courseDTO = new CourseDTO(1L, "Math");
        Course course = CourseDTO.toCourse(courseDTO);

        when(iCourseRepository.courseById(course.getId().getValue())).thenReturn(course);
    }
}