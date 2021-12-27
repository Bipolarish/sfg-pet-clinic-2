package guru.springframework.sfgpetclinic2.repositories;

import guru.springframework.sfgpetclinic2.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
