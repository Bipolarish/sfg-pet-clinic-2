package guru.springframework.sfgpetclinic2.repositories;

import guru.springframework.sfgpetclinic2.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
