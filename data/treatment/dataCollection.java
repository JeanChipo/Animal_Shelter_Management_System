package data.treatment;

import model.animals.Animal;

import java.io.File;
import java.util.HashSet;


public class dataCollection {
    private HashSet<Animal> animals = new HashSet<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public static String verifyEntry(Animal animal) throws IllegalArgumentException {
        switch (animal.getType()) { // getType should return the type of the animal (aerial / aquatic / terrestrial)
            case "aerial":
                String dataAerial = animal.toStore();
                if () {
                    throw new IllegalArgumentException("invalid aerial animal entry");
                }
                break;
            case "aquatic":
                String dataAquatic = animal.toStore();
                if () {
                    throw new IllegalArgumentException("invalid aquatic animal entry");
                }
                break;
            case "terrestrial":
                String dataTerrestrial = animal.toStore();
                if () {
                    throw new IllegalArgumentException("invalid terrestrial animal entry");
                }
                break;
            default:
                throw new IllegalArgumentException("could not find the animal type");
                break;
        }
    }

    public void addToDataBase(Animal animal) {
        String path = "./DataBase.txt";
        File db = new File(path);
        try {
            verifyEntry(animal);
        } catch (IllegalArgumentException e) {
            System.out.println("/!\\ Failed to add " + animal.getName() + " to database !")
        } finally {
            db.add(animal.toStore());
        }
    }

    
    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }
    
    public void updateAnimal (Animal animal) {

    }

    // todo :
    /* inserer dans le txt (type + f° de typage)
     * retirer dans le txt
     * update dans le txt
    */ 


}
