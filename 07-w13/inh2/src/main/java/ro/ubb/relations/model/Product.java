package ro.ubb.relations.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
