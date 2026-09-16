package data.treatment;

import model.animals.Animal;

import java.util.HashSet;

public class dataCollection {
    private HashSet<Animal> animals = new HashSet<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }


}
