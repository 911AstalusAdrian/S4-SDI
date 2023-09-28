package ro.ubb.jdbctemplate.ui;

import ro.ubb.jdbctemplate.model.Student;
import ro.ubb.jdbctemplate.service.StudentService;

import java.util.List;

public class ClientConsole {
    private StudentService studentService;

    public ClientConsole(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runConsole() {
        System.out.println("save...");
        studentService.saveStudent(new Student(null, "s1", 10));
        List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);

        System.out.println("update...");
        Student studentUpdate = allStudents.get(0);
        studentUpdate.setName("update");
        studentService.updateStudent(studentUpdate);
        studentService.getAllStudents()
                .forEach(System.out::println);

        System.out.println("delete...");
        studentService.deleteById(allStudents.get(0).getId());
        studentService.getAllStudents()
                .forEach(System.out::println);
    }
}
