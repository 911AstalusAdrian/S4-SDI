package ro.ubb.catalog.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Discipline;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.web.dto.DisciplineDto;
import ro.ubb.catalog.web.dto.StudentDto;

@Component
public class DisciplineConverter extends BaseConverter<Discipline, DisciplineDto> {

    private static final Logger log = LoggerFactory.getLogger(DisciplineConverter.class);

    @Override
    public Discipline convertDtoToModel(DisciplineDto dto) {
        Discipline discipline = new Discipline(dto.getTitle(), dto.getTeacher(), dto.getCredits());
        discipline.setId(dto.getId());
        return discipline;
    }

    @Override
    public DisciplineDto convertModelToDto(Discipline discipline) {
        DisciplineDto disciplineDto = new DisciplineDto(discipline.getTitle(),
                discipline.getTeacher(), discipline.getCredits());
        disciplineDto.setId(discipline.getId());
        return disciplineDto;
    }
}
