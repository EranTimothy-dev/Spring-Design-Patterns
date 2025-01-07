package spring.designpatterns.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring.designpatterns.builder.Contact;
import spring.designpatterns.factory.Pet;
import spring.designpatterns.factory.PetFactory;
import spring.designpatterns.repository.PresidentEntity;
import spring.designpatterns.repository.PresidentRepository;
import spring.designpatterns.builder.Contact.ContactBuilder;

@RestController
public class AppController {

    private final PetFactory petFactory;
    private final PresidentRepository presidentRepository;
    private final RestTemplate restTemplate;

    public AppController(PetFactory petFactory, PresidentRepository presidentRepository, RestTemplate restTemplate){
        this.petFactory = petFactory;
        this.presidentRepository = presidentRepository;
        this.restTemplate = restTemplate;
    }

    @PostMapping("adoptPet/{type}/{name}")
    public Pet adoptPet(@PathVariable String type,@PathVariable String name){
        Pet pet = this.petFactory.createPet(type);
        pet.setName(name);
        pet.feed();
        return pet;
    }

    @PostMapping("Contact")
    public Contact createContact(@RequestParam(required = false)String firstName,
                                 @RequestParam(required = false)String lastName,
                                 @RequestParam(required = false)String emailAddress){
        return Contact.ContactBuilder.getInstance()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailAddress(emailAddress)
                .build();
    }


    @GetMapping("presidents/{id}")
    public PresidentEntity findPresidentById(@PathVariable Long id){
        return this.presidentRepository.findById(id).get();
    }

    @GetMapping("presidentContact/{id}")
    public Contact getPresidentContactById(@PathVariable Long id){
        // Using template, MVC and builder pattern oin conjunction for demo purposes
        PresidentEntity president = this.restTemplate.getForEntity("http://localhost:8080/presidents/{id}", PresidentEntity.class,id).getBody();
        return ContactBuilder.getInstance().setFirstName(president.getFirstName())
                .setLastName(president.getLastName())
                .setEmailAddress(president.getEmailAddress())
                .build();
    }

}
