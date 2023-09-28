package ro.ubb.relations.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Battery extends Product{

    private boolean isChargeable;

    public Battery(String name, boolean isChargeable) {
        super();

        this.setName(name);
        this.setChargeable(isChargeable);
    }
}
