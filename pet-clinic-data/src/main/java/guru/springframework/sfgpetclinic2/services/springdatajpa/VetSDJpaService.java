package guru.springframework.sfgpetclinic2.services.springdatajpa;

import guru.springframework.sfgpetclinic2.model.Vet;
import guru.springframework.sfgpetclinic2.repositories.VetRepository;
import guru.springframework.sfgpetclinic2.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets= new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long along) {
        return vetRepository.findById(along).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);

    }
}
