package ro.ubb.catalog.core.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
//@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 50)
//@TableGenerator(name = "tab",initialValue = 0, allocationSize = 50)
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    public BaseEntity() {
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
