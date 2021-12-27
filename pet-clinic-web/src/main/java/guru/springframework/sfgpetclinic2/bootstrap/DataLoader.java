package guru.springframework.sfgpetclinic2.bootstrap;

import guru.springframework.sfgpetclinic2.model.*;
import guru.springframework.sfgpetclinic2.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count= petTypeService.findAll().size();
        if(count==0)
        {
            loadData();
        }
    }

    private void loadData() {
        PetType dog= new PetType();
        dog.setName("Dog");
        PetType saveDogPetType= petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("Cat");
        PetType saveCatPetType= petTypeService.save(cat);

        Speciality radiology= new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);


        Speciality surgery= new Speciality();
        radiology.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);


        Speciality dentistry= new Speciality();
        radiology.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);


        Owner owner1=new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Getachew");
        owner1.setAddress("Lafto");
        owner1.setCity("Addis Ababa");
        owner1.setTelephone("56384");

        Pet micksPet= new Pet();
        micksPet.setPetType(saveDogPetType);
        micksPet.setOwner(owner1);
        micksPet.setName("Josi");
        micksPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(micksPet);


        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Makeda");
        owner2.setLastName("Getachew");
        owner2.setAddress("Ada");
        owner2.setCity("Debre zeit");
        owner2.setTelephone("4345363");

        Pet makisCat= new Pet();
        makisCat.setPetType(saveCatPetType);
        makisCat.setOwner(owner2);
        makisCat.setName("wero");
        makisCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(makisCat);

        ownerService.save(owner2);

        Visit catVisit= new Visit();
        catVisit.setPet(makisCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sleepy kitty");

        visitService.save(catVisit);
        System.out.println("Loaded owners.......");

        Vet vet1= new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Dean");
        vet2.setLastName("Winchester");
        vet2.getSpecialities().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Leaked vets....");
    }
}
