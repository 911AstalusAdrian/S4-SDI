package ro.ubb.springdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ubb.springdi.repository.StudentRepository;
import ro.ubb.springdi.repository.StudentRepositoryImpl;
import ro.ubb.springdi.service.StudentService;
import ro.ubb.springdi.service.StudentServiceImpl;
import ro.ubb.springdi.ui.Console;

@Configuration
public class AppConfig {
    @Bean
    Console console() {
        return new Console(studentService());
    }

    private StudentService studentService() {
        return new StudentServiceImpl(studentRepository());
    }

    private StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }
}
