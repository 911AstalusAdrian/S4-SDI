package ro.ubb.springdi.service;

import ro.ubb.springdi.model.Student;
import ro.ubb.springdi.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
