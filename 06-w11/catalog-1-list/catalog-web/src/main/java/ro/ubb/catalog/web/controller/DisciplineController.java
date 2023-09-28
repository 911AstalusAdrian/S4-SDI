package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.service.DisciplineService;
import ro.ubb.catalog.core.service.StudentService;
import ro.ubb.catalog.web.converter.DisciplineConverter;
import ro.ubb.catalog.web.dto.DisciplineDto;
import ro.ubb.catalog.web.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private DisciplineConverter disciplineConverter;

    @GetMapping
    public Set<DisciplineDto> getDisciplines() {
        return disciplineConverter.convertModelsToDtos(disciplineService.getAll());
    }

    @PostMapping
    DisciplineDto saveDiscipline(@RequestBody DisciplineDto dto) {
        return disciplineConverter.convertModelToDto(disciplineService.save(disciplineConverter.convertDtoToModel(dto)));
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> deleteDiscipline(@PathVariable Long id) {
        disciplineService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
