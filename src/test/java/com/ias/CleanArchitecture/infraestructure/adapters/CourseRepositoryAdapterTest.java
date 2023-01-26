package com.ias.CleanArchitecture.infraestructure.adapters;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.course.CourseId;
import com.ias.CleanArchitecture.domain.model.course.CourseName;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.CourseRepositoryAdapter;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.ICourseAdapterRepository;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.CourseDBO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseRepositoryAdapterTest {

    @Autowired
    ICourseAdapterRepository repository;
    @InjectMocks
    CourseRepositoryAdapter courseRepositoryAdapter;

    @BeforeAll
    void init(){
        courseRepositoryAdapter = new CourseRepositoryAdapter(repository);
    }

    @Test
    void saveCourse(){
        Course course = new Course(new CourseId(1l), new CourseName("Name"));

        Course courseDBO =courseRepositoryAdapter.courseSave(course);

        Assertions.assertEquals("Name", courseDBO.getName().getValue());
    }

    @Test
    void getAll(){

        Course course = new Course(new CourseId(1l), new CourseName("Name"));

        courseRepositoryAdapter.courseSave(course);

        List<Course> courseList = courseRepositoryAdapter.courseGetAll();

        Assertions.assertEquals("Name", courseList.get(0).getName().getValue());

    }

    @Test
    void getById(){
        Course course = new Course(new CourseId(1l), new CourseName("Name"));

        courseRepositoryAdapter.courseSave(course);

        Course courseById = courseRepositoryAdapter.courseById(course.getId().getValue());

        Assertions.assertEquals("Name", courseById.getName().getValue());

    }

    @Test
    void update(){
        Course course = new Course(new CourseId(1l), new CourseName("Name"));
        Course courseUpdated = new Course(new CourseId(1l), new CourseName("Math"));

        courseRepositoryAdapter.courseSave(course);

        Course courseUpdate = courseRepositoryAdapter.courseUpdate(courseUpdated);

        Assertions.assertEquals("Math", courseUpdate.getName().getValue());
    }
}
