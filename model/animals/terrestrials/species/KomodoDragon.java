package model.animals.terrestrials.species;

import model.animals.AnimalDescription;
import model.animals.terrestrials.TerrestrialAnimal;

import java.util.Date;

public class KomodoDragon extends TerrestrialAnimal implements AnimalDescription {
    private String specificites;

    public KomodoDragon (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, "lizard");
        this.specificites=null;
    }

    public KomodoDragon (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, "lizard");
        this.specificites=specificities;
    }

    public String description (){
        return "The Komodo dragon is the world's largest living lizard, a formidable apex predator native to the Indonesian islands.";
    }
}