package service;

import model.animals.Animal;
import model.persons.adopters.Adopter;

public class AdoptionService {

    public static void adoption(Adopter adopter, Animal animal){
        if (adopter.canAdopt()){
            animal.setAdoptedState(true);
            System.out.println("The adoption was succesful");
        }

        else{
            System.out.println("The adopter is not responsible enough to take care of this animal");
        }
    }
}
