package data.treatment;

import model.animals.Animal;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class dataCollection {
    private HashSet<Animal> animals = new HashSet<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public static void verifyEntry(Animal animal) throws IllegalArgumentException {
        switch (animal.getType()) { // getType should return the type of the animal (aerial / aquatic / terrestrial)
            case "aerial":
                String dataAerial = animal.toStore();
                if (false) {    // conditions are to be determined
                    throw new IllegalArgumentException("invalid aerial animal entry");
                }
                break;
            case "aquatic":
                String dataAquatic = animal.toStore();
                if (false) {
                    throw new IllegalArgumentException("invalid aquatic animal entry");
                }
                break;
            case "terrestrial":
                String dataTerrestrial = animal.toStore();
                if (false) {
                    throw new IllegalArgumentException("invalid terrestrial animal entry");
                }
                break;
            default:
                throw new IllegalArgumentException("could not find the animal type");
        }
    }


    public void addToDataBase(Animal animal) {
        String path = "data/treatment/DataBase.txt";
        try {
            Writer db = new BufferedWriter(new FileWriter(path, true));
            verifyEntry(animal);
            db.append(animal.toStore());
            db.close();
        } catch (IllegalArgumentException e) {
            System.out.println("/!\\ Failed to add " + animal.getName() + " to database !");
        } catch (IOException e) {
            System.out.println("Database not found");
        }
    }


    public void removeFromDataBase(Animal animal) throws NoSuchElementException{
        String path = "data/treatment/DataBase.txt";
        File db = new File(path);
        if (!db.delete()) {
            throw new NoSuchElementException("Animal not found in database !");
        }
    }
    
    public void updateAnimalEntry(Animal animal) throws NoSuchElementException {
        String path = "data/treatment/DataBase.txt";
        File db = new File(path);
        
        try (Scanner scanner = new Scanner(db)) {
            while (scanner.hasNextLine()) {
                String a = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new NoSuchElementException("Database not found");
        }
    }

    
    public void removeAnimal(Animal animal) throws NoSuchElementException {
        /*
        remove from the animal hashset, NOT THE DATABASE
        */
        boolean removed;
        removed = animals.remove(animal);
        System.out.println( (removed == true) ? "Animal removed" : "Animal not found");
    }


    // todo :
    /* X inserer dans le txt (type + f° de typage)
     * X retirer dans le txt
     * X update dans le txt
     *[] lire le txt
    */ 


}
