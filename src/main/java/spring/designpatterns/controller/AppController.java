package spring.designpatterns.controller;

import org.springframework.web.bind.annotation.*;
import spring.designpatterns.builder.Contact;
import spring.designpatterns.factory.Pet;
import spring.designpatterns.factory.PetFactory;

@RestController
public class AppController {

    private final PetFactory petFactory;

    public AppController(PetFactory petFactory){
        this.petFactory = petFactory;
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
}
