package ro.ubb.springdi.repository;

import ro.ubb.springdi.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
