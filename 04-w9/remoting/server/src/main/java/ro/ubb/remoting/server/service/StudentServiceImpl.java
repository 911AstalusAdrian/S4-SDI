package ro.ubb.remoting.server.service;

import ro.ubb.remoting.common.Student;
import ro.ubb.remoting.common.StudentService;

import java.util.Arrays;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    public List<Student> getAllStudents() {
        return Arrays.asList(
                new Student(1l, "s1", 10),
                new Student(2l, "s2", 10)
        );
    }
}
