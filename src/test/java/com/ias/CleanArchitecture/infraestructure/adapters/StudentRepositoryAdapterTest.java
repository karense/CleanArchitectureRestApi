package com.ias.CleanArchitecture.infraestructure.adapters;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.course.CourseId;
import com.ias.CleanArchitecture.domain.model.course.CourseName;
import com.ias.CleanArchitecture.domain.model.gateways.IStudentRepository;
import com.ias.CleanArchitecture.domain.model.student.*;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.ICourseAdapterRepository;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.IStudentAdapterRepository;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.StudentRepositoryAdapter;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.CourseDBO;
import com.ias.CleanArchitecture.infraestructure.adapters.jpa.entity.StudentDBO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentRepositoryAdapterTest {

    @Autowired
    IStudentAdapterRepository repository;

    @Autowired
    ICourseAdapterRepository courseAdapterRepository;

    @InjectMocks
    StudentRepositoryAdapter studentRepositoryAdapter;

    @BeforeAll
    void init(){
        studentRepositoryAdapter = new StudentRepositoryAdapter(repository, courseAdapterRepository);
    }

    @Test
    void save(){
        Course course = new Course(new CourseId(1l), new CourseName("Math"));

        courseAdapterRepository.save(new CourseDBO(course));

        Student student = new Student(
                new StudentId(1),
                new StudentName("Karen"),
                new StudentPhone("43566"),
                new StudentEmail("karen@ka"),
                course
        );

        Student studentSaved = studentRepositoryAdapter.studentSave(student);

        Assertions.assertEquals("Karen", studentSaved.getName().getValue());
    }

    @Test
    void getAll(){
        Course course = new Course(new CourseId(1l), new CourseName("Math"));

        courseAdapterRepository.save(new CourseDBO(course));

        Student student = new Student(
                new StudentId(1),
                new StudentName("Karen"),
                new StudentPhone("43566"),
                new StudentEmail("karen@ka"),
                course
        );

        Student studentSaved = studentRepositoryAdapter.studentSave(student);

        List<Student> studentList = studentRepositoryAdapter.getAll();

        Assertions.assertEquals(studentSaved.getName().getValue(), studentList.get(0).getName().getValue());

    }

    @Test
    void getById(){
        Course course = new Course(new CourseId(1l), new CourseName("Math"));

        courseAdapterRepository.save(new CourseDBO(course));

        Student student = new Student(
                new StudentId(1),
                new StudentName("Karen"),
                new StudentPhone("43566"),
                new StudentEmail("karen@ka"),
                course
        );

        studentRepositoryAdapter.studentSave(student);

       Student studentById = studentRepositoryAdapter.getById(student.getId().getValue());

       Assertions.assertEquals("Karen", studentById.getName().getValue());
    }

    @Test
    void update(){

        Course course = new Course(new CourseId(1l), new CourseName("Math"));

        courseAdapterRepository.save(new CourseDBO(course));

        Student student = new Student(
                new StudentId(1),
                new StudentName("Karen"),
                new StudentPhone("43566"),
                new StudentEmail("karen@ka"),
                course
        );

        Student studentUpdate = new Student(
                new StudentId(1),
                new StudentName("Karen S"),
                new StudentPhone("43566"),
                new StudentEmail("karen@ka"),
                course
        );

        studentRepositoryAdapter.studentSave(student);
        Student studentUpdated = studentRepositoryAdapter.update(studentUpdate);

        Assertions.assertEquals("Karen S", studentUpdated.getName().getValue());

    }
}
