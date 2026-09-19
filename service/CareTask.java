package service;

import model.animals.Animal;
import model.persons.volunteers.Volunteer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CareTask {
    private static Set<Animal> careSet = new HashSet<>();

    public static void takeCare(Volunteer volunteer, Animal animal){
        if (volunteer.canTakeCare(animal)){
            careSet.add(animal);
        }
        else{
            System.out.println("The volunteer dont have the skill to take care of this animal or they are not available");
        }
    }

    public static void displayCare(){
        for (Animal animal:careSet){
            System.out.println("this animal is being taking care off : "+ animal);
        }
    }
}
