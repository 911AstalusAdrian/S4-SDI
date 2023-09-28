package ro.ubb.springdi.ui;

import ro.ubb.springdi.service.StudentService;

public class Console {
    private StudentService studentService;

    public Console(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runConsole() {
        studentService.getAllStudents()
                .forEach(student -> System.out.println(student));
    }
}
