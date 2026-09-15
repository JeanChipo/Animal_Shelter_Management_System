package model.animals.terrestrials.species;

import model.animals.AnimalDescription;
import model.animals.terrestrials.TerrestrialAnimal;

import java.util.Date;

public class Human extends TerrestrialAnimal implements AnimalDescription {
    private String specificites;

    public Human (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, mammal);
        this.specificites = null;
    }

    public Human (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, mammal);
        this.specificites = specificities;
    }

    public String description (){
        return "Humans are bipedal primates known for their intelligence and complex social structures. They have a wide range of physical characteristics and are capable of creating and using tools.";
    }
}