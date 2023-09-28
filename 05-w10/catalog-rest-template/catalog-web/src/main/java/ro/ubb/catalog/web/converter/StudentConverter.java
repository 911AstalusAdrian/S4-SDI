package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.web.dto.StudentDto;

@Component
public class StudentConverter extends BaseConverter<Student, StudentDto> {
    @Override
    public Student convertDtoToModel(StudentDto dto) {
        var model = new Student();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setGrade(dto.getGrade());
        return model;
    }

    @Override
    public StudentDto convertModelToDto(Student student) {
        StudentDto dto = new StudentDto(student.getName(), student.getGrade());
        dto.setId(student.getId());
        return dto;
    }
}
