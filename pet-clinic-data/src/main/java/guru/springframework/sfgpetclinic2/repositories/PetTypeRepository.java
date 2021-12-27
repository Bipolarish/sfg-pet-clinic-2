package guru.springframework.sfgpetclinic2.repositories;

import guru.springframework.sfgpetclinic2.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
