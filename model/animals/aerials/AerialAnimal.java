package model.animals.aerials;

import model.animals.Animal;

import java.util.Date;

public abstract class AerialAnimal extends Animal {
    private boolean canFly;
    AerialAnimal(String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, boolean canFly){
        super(name,adress,arrivalDate,adopted,age,bloodType,"Aerial");
        this.canFly = canFly;
    }
}