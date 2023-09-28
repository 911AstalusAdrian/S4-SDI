package ro.ubb.remoting.client.ui;

import ro.ubb.remoting.common.StudentService;

public class ClientConsole {
    private StudentService studentService;

    public ClientConsole(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runConsole() {
        studentService.getAllStudents()
                .forEach(student -> System.out.println(student));
    }
}
