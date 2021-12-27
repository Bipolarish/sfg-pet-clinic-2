package guru.springframework.sfgpetclinic2.repositories;

import guru.springframework.sfgpetclinic2.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
