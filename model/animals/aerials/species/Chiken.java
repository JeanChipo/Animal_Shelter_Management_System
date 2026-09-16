package model.animals.aerials.species;

import model.animals.AnimalDescription;
import model.animals.aerials.AerialAnimal;

import java.util.Date;

public class Chiken extends AerialAnimal implements AnimalDescription {
    private String specificites;

    public Chiken (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, false);
        this.specificites=null;
    }

    public Chiken (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, false);
        this.specificites=specificities;
    }

    public String description (){
        return "The chicken is a domesticated bird that is widely kept for its meat and eggs. It is known for its distinctive clucking sound, feathered body, and ability to lay eggs regularly. Chickens are social animals that can be found in various breeds, each with unique characteristics and appearances.";
    }

}
