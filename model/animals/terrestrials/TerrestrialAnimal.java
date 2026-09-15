package model.animals.terrestrials;

import model.animals.Animal;

import java.util.Date;

public abstract class TerrestrialAnimal extends Animal {
    private String subType;
    public TerrestrialAnimal(String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String subType){
        super(name,adress,arrivalDate,adopted,age,bloodType,"Terrestrial");
        this.subType = subType;
    }
}
