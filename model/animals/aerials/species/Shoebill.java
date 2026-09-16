package model.animals.aerials.species;

import model.animals.AnimalDescription;
import model.animals.aerials.AerialAnimal;

import java.util.Date;

public class Shoebill extends AerialAnimal implements AnimalDescription {
    private String specificites;

    public Shoebill (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, true);
        this.specificites=null;
    }

    public Shoebill (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, true);
        this.specificites=specificities;
    }

    public String description (){
        return "The Shoebill is a large, prehistoric-looking bird with a massive shoe-shaped bill. It is known for its slow movements and can be found in the swamps and wetlands of East Africa. This bird requires a spacious enclosure with water features and plenty of hiding spots to mimic its natural habitat.";
    }
}
