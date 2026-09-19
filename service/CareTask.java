package service;

import model.animals.Animal;
import model.persons.volunteers.Volunteer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CareTask {
    private Set<Animal> careSet = new HashSet<>();

    public void takeCare(Volunteer volunteer, Animal animal){
        if (volunteer.canTakeCare(animal)){
            careSet.add(animal);
        }
        else{
            System.out.println("The volunteer dont have the skill to take care of this animal");
        }
    }

    public void displayCare(){
        for (Animal animal:careSet){
            System.out.println("this animal is being taking care off : "+ animal);
        }
    }
}
