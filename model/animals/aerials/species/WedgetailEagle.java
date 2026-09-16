package model.animals.aerials.species;

import model.animals.AnimalDescription;
import model.animals.aerials.AerialAnimal;

import java.util.Date;

public class WedgetailEagle extends AerialAnimal implements AnimalDescription {
    private String specificites;

    public WedgetailEagle (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, true);
        this.specificites=null;
    }

    public WedgetailEagle (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, true);
        this.specificites=specificities;
    }

    public String description (){
        return "The wedge-tailed eagle is a large bird of prey native to Australia and parts of New Guinea. It is known for its distinctive wedge-shaped tail, which gives it its name. These eagles are powerful hunters, capable of taking down a variety of prey, including mammals, birds, and reptiles. They are also known for their impressive soaring abilities and can often be seen gliding high in the sky. Wedge-tailed eagles are an iconic species in Australia and are often associated with the country's wilderness and natural beauty.";
    }
}
