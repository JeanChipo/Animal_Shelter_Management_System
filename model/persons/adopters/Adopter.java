package model.persons.adopters;

import exception.ShelterException;
import model.animals.Animal;
import model.persons.Person;

public class Adopter extends Person {
    int eligibility;

    Adopter(String id, String name, int age, int eligibility){
        super(id,name,age);
        this.eligibility = eligibility;
        if (eligibility < 0 || eligibility > 10){
            throw new ShelterException("Eligibility must be between 0 and 10");
        }

    }

    public boolean canAdopt(){
        boolean can = false;
        if (eligibility>5){
            can = true;
        }
        else{
            System.out.println("Eligibility must be above 5 to adopt an animal");
        }

        return can;

    }

    public void display() {
        System.out.println("id : " + getId() + ", name : " + getName() + ", age : " + getAge() +
                ", eligibility : " + eligibility);
    }


}