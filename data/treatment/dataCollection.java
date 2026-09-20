package data.treatment;

import model.animals.Animal;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class dataCollection {
    private HashSet<Animal> animals = new HashSet<>();
    private static int id = 0;

    public int getCurrentId() {
        return id;
    }

    // if more getters are needed, let me know
    public String getIdForAnimal(Animal animal, String filePath) {
        File db = new File(filePath);
        String animalData = animal.toStore();
        try {
            Scanner scanner = new Scanner(db);
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                if (currentLine.endsWith(animalData)) {
                    int animalIdLength = currentLine.length() - animalData.length();
                    String animalId = currentLine.substring(0, animalIdLength);
                    scanner.close();
                    return animalId;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Database not found");
        }
        return "";
    }

    public void addAnimal(Animal animal) {
        /* 
        adds to the animal hashset, NOT THE DATABASE
        */
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) throws NoSuchElementException {
        /*
        remove from the animal hashset, NOT THE DATABASE
        */
        boolean removed;
        removed = animals.remove(animal);
        System.out.println( (removed == true) ? "Animal removed" : "Animal not found");
    }

    public void displayAnimals() {
        if (animals.isEmpty()) {
            System.out.println("no animal found");
            return;
        }
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public static void verifyEntry(Animal animal) throws InvalidEntryException {
        String type = animal.getType() == null ? "" : animal.getType().toLowerCase();

        switch (type) {
            case "aerial":
                String dataAerial = animal.toStore();
                if (animal.getName() == null 
                        || animal.getName().isBlank()
                        || animal.getAdress() == null 
                        || animal.getAdress().isBlank()
                        || animal.getArrivalDate() == null
                        || animal.getAge() < 0
                        || animal.getBloodType() == null 
                        || animal.getBloodType().isBlank()) {
                    throw new InvalidEntryException("invalid aerial animal entry");
                }
                break;
            case "aquatic":
                String dataAquatic = animal.toStore();
                if (animal.getName() == null 
                        || animal.getName().isBlank()
                        || animal.getAdress() == null 
                        || animal.getAdress().isBlank()
                        || animal.getArrivalDate() == null
                        || animal.getAge() < 0
                        || animal.getBloodType() == null 
                        || animal.getBloodType().isBlank()) {
                    throw new InvalidEntryException("invalid aquatic animal entry");
                }
                break;
            case "terrestrial":
                String dataTerrestrial = animal.toStore();
                if (animal.getName() == null 
                        || animal.getName().isBlank()
                        || animal.getAdress() == null 
                        || animal.getAdress().isBlank()
                        || animal.getArrivalDate() == null
                        || animal.getAge() < 0
                        || animal.getBloodType() == null 
                        || animal.getBloodType().isBlank()) {
                    throw new InvalidEntryException("invalid terrestrial animal entry");
                }
                break;
            default:
                throw new IllegalArgumentException("could not find the animal type");
        }
    }


    public void addToDataBase(Animal animal) {
        String path = "data/treatment/DataBase.txt";
        try {
            verifyEntry(animal);
            try (Writer db = new BufferedWriter(new FileWriter(path, true))) {
                db.append(id + "#" + animal.toStore() + '\n');
            }
            id++;
        } catch (InvalidEntryException e) {
            String name = animal == null ? "animal" : animal.getName();
            System.out.println("/!\\ Failed to add " + name + " to database !");
        } catch (IOException e) {
            System.out.println("Database not found");
        }
    }


    public void removeFromDataBase(Animal animal) throws NoSuchElementException{
        String path = "data/treatment/DataBase.txt";
        File db = new File(path);
        String animalData = animal.toStore();
        String curLine = "";
        String remainingData = "";
        boolean removed = false;

        try {
            Scanner scanner = new Scanner(db);
            while (scanner.hasNextLine()) {
                curLine = scanner.nextLine();
                if (!removed && curLine.endsWith(animalData)) {
                    removed = true;
                } else {
                    remainingData += curLine + System.lineSeparator();
                }
            }
            scanner.close();
            if (!removed) {
                throw new NoSuchElementException("Animal not found in database");
            }
            Writer writer = new BufferedWriter(new FileWriter(db, false));
            writer.write(remainingData);
            writer.close();
        } catch (IOException e) {
            throw new NoSuchElementException("Could not update database");
        }
    }

    public String formatOutput(String in) {
        String[] attributes = {
                "ID", "Name", "Address", "Arrival date", "Adopted",
                "Age", "Blood type", "Type-specific attribute", "Specificities"
        };
        String out = "";
        int cpt = 0;

        for (String value : in.split("#")) {
            if (!value.isBlank()) {
                String attribute = attributes[cpt];
                out += "| " + attribute + ": " + value.trim() + "\n";
                cpt++;
            }
        }
        return out;
    }

    public String listDataBase(String filePath) {
        File db = new File(filePath);
        String output = "";

        try (Scanner scanner = new Scanner(db)) {
            while (scanner.hasNextLine()) {
                output += scanner.nextLine() + System.lineSeparator();
            }
        } catch (FileNotFoundException e) {
            throw new NoSuchElementException("database not found");
        }
        output = formatOutput(output) + "\n";
        return (output.isBlank()) ? "no animals found in database" : output;
    }
}
