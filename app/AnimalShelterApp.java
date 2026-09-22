package app;

import java.util.Scanner;

import model.animals.Animal;
import model.animals.aerials.species.Chiken;
import model.animals.aerials.species.Dodo;
import model.animals.aerials.species.Quetzalcoatlus;
import model.animals.aerials.species.Shoebill;
import model.animals.aerials.species.WedgetailEagle;
import model.animals.aquatics.species.Magnapinna;
import model.animals.aquatics.species.MantisShrimp;
import model.animals.aquatics.species.SnappingTurtle;
import model.animals.aquatics.species.WhaleShark;
import model.animals.aquatics.species.YetiCrab;
import model.animals.terrestrials.species.BalistaSpider;
import model.animals.terrestrials.species.BengalTiger;
import model.animals.terrestrials.species.Human;
import model.animals.terrestrials.species.JavaRhinoceros;
import model.animals.terrestrials.species.KomodoDragon;
import repository.MenuOption;
import java.sql.Date;


import data.treatment.*;;

public class AnimalShelterApp {

    private static final String FILE_NAME = "data/treatment/DataBase.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            dataCollection collectionOfDatas = new dataCollection();
            MenuOption requestType;
            
            do{
                requestType = getRequest(scanner);
                if (requestType != MenuOption.END) {
                    if (shouldDisplay(requestType, scanner, collectionOfDatas)) {
                    }
                }
                            
            } while (requestType != MenuOption.END);
            
            System.out.println("Program terminated");

        }catch(Exception e){
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }

    }


    private static MenuOption getRequest(Scanner scanner) {
        System.out.println("Enter request:\n"
                + "1 - List of the animals\n"
                + "2 - Adopt an animal\n"
                + "3 - Add an animal\n"
                + "4 - Test the program\n"
                + "5 - End the programm\n");

        while (true) {

            System.out.print("Please enter your selection (1-5): ");

            try {

                String input = scanner.nextLine().trim();

                int choice = Integer.parseInt(input);

                return MenuOption.fromValue(choice);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number between 1 and 4.");

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Invalid input. Please enter a number between 1 and 4.");
            }
        }
    }

//    private static void displayInfos(dataCollection collectionOfData, MenuOption option){
//
//        String description =switch (option){
//            case VIEW -> "View all animals";
//            case ADOPT -> "Adopt an animal";
//            case ADD -> "Add an animal",
//            case REMOVE -> "Remove an animal",
//            case TEST -> "Test the program";
//            case END -> "End the program";
//        };
//
//        System.out.printf("%n%s:%n%n", description);
//
//        try{
//
//        }
//    }



    private static boolean shouldDisplay(MenuOption option, Scanner scanner, dataCollection data) {
        switch (option) {
            case VIEW:
                System.out.println(data.listDataBase(FILE_NAME));
                return true;

            case ADOPT:
                Dodo adoptedDodo = new Dodo("Kiko", "Male", Date.valueOf("2021-04-18"), false, 4, "Healthy");
                Dodo adoptedDodoTrue = new Dodo("Kiko", "Male", Date.valueOf("2021-04-18"), true, 4, "Healthy");
                data.removeFromDataBase(adoptedDodo);
                data.addToDataBase(adoptedDodoTrue);
                System.out.println("adopted Kiko");
                return true;

            case ADD:
                System.out.println("adding all animals");
                Dodo dodo = new Dodo("Kiko", "Male", Date.valueOf("2021-04-18"), false, 4, "Healthy");
                System.out.println("adding a dodo");
                data.addToDataBase(dodo);

                Chiken chiken = new Chiken("Coco", "Female", Date.valueOf("2022-05-10"), false, 2, "Healthy", "Lays eggs");
                System.out.println("adding a chicken");
                data.addToDataBase(chiken);

                Quetzalcoatlus quetzalcoatlus = new Quetzalcoatlus("Quito", "Male", Date.valueOf("2020-11-08"), false, 6, "Healthy", "Glides");
                System.out.println("adding a quetzalcoatlus");
                data.addToDataBase(quetzalcoatlus);

                Shoebill shoebill = new Shoebill("Shoe", "Male", Date.valueOf("2019-08-12"), false, 5, "Healthy", "Big beak");
                System.out.println("adding a shoebill");
                data.addToDataBase(shoebill);

                WedgetailEagle wedgetailEagle = new WedgetailEagle("Wedge", "Female", Date.valueOf("2021-06-15"), false, 3, "Healthy", "Sharp eyes");
                System.out.println("adding a wedgetail eagle");
                data.addToDataBase(wedgetailEagle);

                Magnapinna magnapinna = new Magnapinna("Mango", "Female", Date.valueOf("2023-02-03"), false, 1, "Healthy", "Deep sea swimmer");
                System.out.println("adding a magnapinna");
                data.addToDataBase(magnapinna);

                MantisShrimp mantisShrimp = new MantisShrimp("Shell", "Male", Date.valueOf("2022-09-07"), false, 2, "Healthy", "Colorful claws");
                System.out.println("adding a mantis shrimp");
                data.addToDataBase(mantisShrimp);

                SnappingTurtle snappingTurtle = new SnappingTurtle("Snap", "Male", Date.valueOf("2018-04-22"), false, 8, "Healthy", "Fast snap");
                System.out.println("adding a snapping turtle");
                data.addToDataBase(snappingTurtle);

                WhaleShark whaleShark = new WhaleShark("Wally", "Female", Date.valueOf("2021-12-05"), false, 7, "Healthy", "Huge filter feeder");
                System.out.println("adding a whale shark");
                data.addToDataBase(whaleShark);

                YetiCrab yetiCrab = new YetiCrab("Yeti", "Female", Date.valueOf("2024-01-09"), false, 1, "Healthy", "Cold-loving crab");
                System.out.println("adding a yeti crab");
                data.addToDataBase(yetiCrab);

                BalistaSpider balistaSpider = new BalistaSpider("Spike", "Male", Date.valueOf("2020-07-14"), false, 4, "Healthy", "Venomous legs");
                System.out.println("adding a balista spider");
                data.addToDataBase(balistaSpider);

                BengalTiger bengalTiger = new BengalTiger("Raja", "Male", Date.valueOf("2019-03-19"), false, 6, "Healthy", "Royal stripes");
                System.out.println("adding a bengal tiger");
                data.addToDataBase(bengalTiger);

                Human human = new Human("Hugo", "Male", Date.valueOf("2016-10-04"), false, 14, "Healthy", "Very clever");
                System.out.println("adding a human");
                data.addToDataBase(human);

                JavaRhinoceros javaRhinoceros = new JavaRhinoceros("Rino", "Female", Date.valueOf("2017-11-02"), false, 9, "Healthy", "Strong horn");
                System.out.println("adding a java rhinoceros");
                data.addToDataBase(javaRhinoceros);

                KomodoDragon komodoDragon = new KomodoDragon("Komo", "Female", Date.valueOf("2018-06-30"), false, 7, "Healthy", "Apex predator");
                System.out.println("adding a komodo dragon");
                data.addToDataBase(komodoDragon);
                return true;

            case TEST:
                dataTester dt = new dataTester("data/treatment/DataBase.txt");
                dt.test();
                return true;

            case END:
                return false;

            default:
                throw new IllegalArgumentException("Unexpected value: " + option);
        }
    }
}

