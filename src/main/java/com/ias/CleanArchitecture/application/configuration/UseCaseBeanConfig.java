package com.ias.CleanArchitecture.application.configuration;

import com.ias.CleanArchitecture.domain.model.gateways.ICourseRepository;
import com.ias.CleanArchitecture.domain.model.gateways.IStudentRepository;
import com.ias.CleanArchitecture.domain.usecase.CourseUseCase;
import com.ias.CleanArchitecture.domain.usecase.StudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public CourseUseCase courseUseCase(ICourseRepository repository){
        return new CourseUseCase(repository);
    }

    @Bean
    public StudentUseCase studentUseCase(IStudentRepository repository){
        return new StudentUseCase(repository);
    }

}
