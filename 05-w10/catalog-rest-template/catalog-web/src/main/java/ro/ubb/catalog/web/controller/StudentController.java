package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.service.StudentService;
import ro.ubb.catalog.web.converter.StudentConverter;
import ro.ubb.catalog.web.dto.StudentDto;
import ro.ubb.catalog.web.dto.StudentsDto;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentConverter studentConverter;

//    @RequestMapping(value = "/students")
//    List<Student> getAllStudents() {
//        //todo: logs
//        return studentService.getAllStudents();
//
//    }

    @RequestMapping(value = "/students")
    StudentsDto getAllStudents() {
        //todo: logs

        return new StudentsDto(
                studentConverter.convertModelsToDtos(
                        studentService.getAllStudents()));
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    StudentDto addStudent(@RequestBody StudentDto studentDto) {
        // TODO: Log parameters
        var student = studentConverter.convertDtoToModel(studentDto);

        var result = studentService.saveStudent(student);

        var resultModel = studentConverter.convertModelToDto(result);

        // TODO: Log result model
        return resultModel;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    StudentDto updateStudent(@PathVariable Long id,
                             @RequestBody StudentDto dto) {
        return
                studentConverter.convertModelToDto(
                        studentService.updateStudent(
                                studentConverter.convertDtoToModel(dto)
                        ));
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
