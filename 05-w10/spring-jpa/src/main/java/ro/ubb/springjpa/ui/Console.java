package ro.ubb.springjpa.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.springjpa.model.Student;
import ro.ubb.springjpa.service.StudentService;

import java.util.List;

/**
 * Created by radu.
 */
@Component
public class Console {
    @Autowired
    private StudentService studentService;

    public void runConsole() {
        //todo: logs

        System.out.println("save...........");
        studentService.saveStudent(new Student("s1", 10));
        printAllStudents();

        System.out.println("\nupdate................");
        Student student = studentService.getAllStudents().get(0);
        student.setGrade(9);
        studentService.updateStudent(student);
        printAllStudents();

        System.out.println("\ndelete...........");
        studentService.deleteById(student.getId());
        printAllStudents();

    }

    private void printAllStudents() {
        List<Student> students = studentService.getAllStudents();
        students.forEach(System.out::println);
    }
}
