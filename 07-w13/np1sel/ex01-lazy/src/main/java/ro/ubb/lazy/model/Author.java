package ro.ubb.lazy.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by radu.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@ToString(exclude = "books")
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author",
            fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();


}
