package ro.ubb.lazy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by radu.
 */
@Entity
@Table(name = "publisher")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Publisher implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
