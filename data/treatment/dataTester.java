package data.treatment;

import model.animals.aerials.species.Dodo;
import model.animals.aquatics.species.MantisShrimp;
import model.animals.terrestrials.species.JavaRhinoceros;
import java.sql.Date;
import java.util.NoSuchElementException;

public class dataTester {
    private final String pathToDataBase;

    public dataTester(String pathToDB) {
        pathToDataBase = pathToDB;
    }

    public void test() {
        // testing with each animal type
        Dodo dod = new Dodo("Kiko", "Male", Date.valueOf("2021-04-18"), false, 4, "Healthy");
        MantisShrimp shrimp = new MantisShrimp("Coral", "Female", Date.valueOf("2023-07-09"), false, 1, "Healthy", "Saltwater");
        JavaRhinoceros rhino = new JavaRhinoceros("Maya", "Female", Date.valueOf("2017-11-02"), false, 7, "Needs hoof trimming", "");
        dataCollection data = new dataCollection();

        System.out.println("--= Testing local memory =--");
        System.out.printf("Adding animals in local memory...");
        data.addAnimal(dod);
        data.addAnimal(shrimp);
        data.addAnimal(rhino);
        System.out.println(" done");
        
        System.out.println("Animals in local memory : ");
        data.displayAnimals();
        
        System.out.println("Removing animals in local memory...");
        data.removeAnimal(dod);
        data.removeAnimal(shrimp);
        data.removeAnimal(rhino);
        System.out.printf("Trying to remove non existing animal : ");
        data.removeAnimal(rhino);
        
        System.out.println("Animals in local memory (after removal): ");
        data.displayAnimals();
        System.out.println("--= end =--");
        
        System.out.println("\n--= Testing database =--");
        System.out.println("Adding animals in database...");
        data.addToDataBase(dod);
        data.addToDataBase(shrimp);
        data.addToDataBase(rhino);
        
        System.out.println("Animals in database : ");
        System.out.println(data.listDataBase(pathToDataBase));
        
        System.out.println("getting the ID of each animal in the database...");
        System.out.println("> dodo : " + data.getIdForAnimal(dod, pathToDataBase));
        System.out.println("> shrimp : " + data.getIdForAnimal(shrimp, pathToDataBase));
        System.out.println("> rhino : " + data.getIdForAnimal(rhino, pathToDataBase));
        
        System.out.println("Removing animals in database...");
        try {
            data.removeFromDataBase(dod);
            data.removeFromDataBase(shrimp);
            data.removeFromDataBase(rhino);
            System.out.printf("Trying to remove non existing animal : ");
            data.removeFromDataBase(rhino);
        } catch (NoSuchElementException e) {
            System.out.println("Animal not found in database");
        }
        System.out.println("done");
        
        System.out.println("Animals in database (after removal) : ");
        System.out.println("> " + data.listDataBase(pathToDataBase));
        System.out.println("--= end =--");
    }
}
