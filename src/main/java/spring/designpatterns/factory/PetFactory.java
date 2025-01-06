package spring.designpatterns.factory;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PetFactory {

    public Pet createPet(String animalType){
        if (!StringUtils.hasLength(animalType)){
            throw new UnsupportedOperationException("animalType is required");
        }
        switch (animalType.toLowerCase()){
            case "dog":
                return new Dog();
            default:
                throw new UnsupportedOperationException("animalType not supported");
        }
    }
}
