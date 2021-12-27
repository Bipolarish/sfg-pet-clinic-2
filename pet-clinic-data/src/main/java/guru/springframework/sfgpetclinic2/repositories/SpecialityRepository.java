package guru.springframework.sfgpetclinic2.repositories;

import guru.springframework.sfgpetclinic2.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
