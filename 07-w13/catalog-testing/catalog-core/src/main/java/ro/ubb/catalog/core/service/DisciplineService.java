package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Discipline;

import java.util.List;

/**
 * Created by radu.
 */

public interface DisciplineService {
    List<Discipline> findAll();

    Discipline createDiscipline(String name, String teacher, Integer credits);
}
