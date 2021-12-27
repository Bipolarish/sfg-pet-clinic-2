package guru.springframework.sfgpetclinic2.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends guru.springframework.sfgpetclinic2.model.BaseEntity {

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

}
