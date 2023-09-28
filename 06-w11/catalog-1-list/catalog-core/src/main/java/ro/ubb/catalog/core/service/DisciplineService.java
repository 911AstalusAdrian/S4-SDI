package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Discipline;

import java.util.List;

public interface DisciplineService {
    List<Discipline> getAll();

    Discipline save(Discipline discipline);

    void deleteById(Long id);
}
