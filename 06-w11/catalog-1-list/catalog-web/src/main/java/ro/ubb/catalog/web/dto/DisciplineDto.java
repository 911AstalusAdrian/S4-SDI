package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class DisciplineDto extends BaseDto {
    private String title;
    private String teacher;
    private int credits;
}
