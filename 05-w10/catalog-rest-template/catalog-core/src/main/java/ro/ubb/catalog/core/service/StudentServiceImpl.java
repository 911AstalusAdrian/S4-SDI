package ro.ubb.catalog.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        //todo: logs
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        // TODO: Log Parameter student

        // TODO: Log return value of studentRepository.save()
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        //todo: logs
        Student updateStudent = studentRepository.findById(student.getId()).orElseThrow();
        updateStudent.setName(student.getName());
        updateStudent.setGrade(student.getGrade());
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        //todo: logs
        studentRepository.deleteById(id);
    }
}
