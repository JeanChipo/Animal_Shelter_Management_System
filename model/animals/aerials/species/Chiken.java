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
        return "A magnificent Late Cretaceous pterosaur the size of a giraffe, this giant of the skies requires a vast open-air enclosure and makes a truly awe-inspiring, high-flying centerpiece for the most ambitious caretakers.";
    }

}
