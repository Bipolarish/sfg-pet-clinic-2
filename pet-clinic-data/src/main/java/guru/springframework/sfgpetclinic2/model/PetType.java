package guru.springframework.sfgpetclinic2.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends guru.springframework.sfgpetclinic2.model.BaseEntity {
    @Column(name = "name")
    private String name;

}
