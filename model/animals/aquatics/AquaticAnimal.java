package model.animals.aquatics;

import model.animals.Animal;

import java.util.Date;

public abstract class AquaticAnimal extends Animal {
    private boolean scales;
    AquaticAnimal(String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, boolean scales){
        super(name,adress,arrivalDate,adopted,age,bloodType,"Aquatic");
        this.scales = scales;
    }
}
