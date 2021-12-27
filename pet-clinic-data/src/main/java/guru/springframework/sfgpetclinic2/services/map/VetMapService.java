package guru.springframework.sfgpetclinic2.services.map;

import guru.springframework.sfgpetclinic2.model.Speciality;
import guru.springframework.sfgpetclinic2.model.Vet;
import guru.springframework.sfgpetclinic2.services.SpecialityService;
import guru.springframework.sfgpetclinic2.services.VetService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Primary

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size()> 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality= specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
