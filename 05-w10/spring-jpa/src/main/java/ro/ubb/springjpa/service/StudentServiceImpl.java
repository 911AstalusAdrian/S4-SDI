package ro.ubb.springjpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.springjpa.model.Student;
import ro.ubb.springjpa.repository.StudentRepository;

import java.util.List;

/**
 * Created by radu.
 */
@Service
public class StudentServiceImpl implements StudentService {
    public static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        log.trace("getAllStudents --- method entered");

        List<Student> result = studentRepository.findAll();

        log.trace("getAllStudents: result={}", result);

        return result;
    }

    @Override
    public void saveStudent(Student student) {
        //todo: for each method, log at least: the fact that the method was entered and finished, input data (if any), returned values (if any)
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        log.trace("updateStudent - method entered: student={}", student);

        studentRepository.findById(student.getId())
                .ifPresent(s -> {
                    s.setName(student.getName());
                    s.setGrade(student.getGrade());
                    log.debug("updateStudent - updated: s={}", s);
                });

        log.trace("updateStudent - method finished");
    }

    @Override
    public void deleteById(Long id) {
        //todo: logs
        studentRepository.deleteById(id);
    }
}
