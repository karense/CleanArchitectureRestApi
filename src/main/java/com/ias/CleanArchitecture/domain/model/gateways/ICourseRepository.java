package com.ias.CleanArchitecture.domain.model.gateways;

import com.ias.CleanArchitecture.domain.model.course.Course;
import com.ias.CleanArchitecture.domain.model.course.dto.CourseDTO;

import java.util.List;

public interface ICourseRepository {
    public Course courseSave(Course course);
    public List<Course> courseGetAll();
    public Course courseUpdate(Course course);

    public Course courseById(long id);
}
