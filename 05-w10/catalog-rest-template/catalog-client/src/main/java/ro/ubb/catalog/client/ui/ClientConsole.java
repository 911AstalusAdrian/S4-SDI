package ro.ubb.catalog.client.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.dto.StudentDto;
import ro.ubb.catalog.web.dto.StudentsDto;

@Component
public class ClientConsole {

    @Autowired
    private RestTemplate restTemplate;

    public void runConsole() {
        String url = "http://localhost:8080/api/students";
        StudentsDto students = restTemplate.getForObject(url, StudentsDto.class);
        System.out.println(students);

        StudentDto savedStudent = restTemplate.postForObject(url,
                new StudentDto("saved-st", 10),
                StudentDto.class);
        System.out.println("saved student:");
        System.out.println(savedStudent);

        savedStudent.setName("update-st");
        restTemplate.put(url + "/{id}", savedStudent, savedStudent.getId());
        System.out.println("update:");
        System.out.println(restTemplate.getForObject(url, StudentsDto.class));

        restTemplate.delete(url + "/{id}", savedStudent.getId());
        System.out.println("delete:");
        System.out.println(restTemplate.getForObject(url, StudentsDto.class));
    }
}
