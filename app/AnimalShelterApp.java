package app;

import java.util.Scanner;

import data.treatment.dataCollection;
import model.animals.Animal;
import model.animals.aerials.species.Dodo;
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
                + "4 - End the programm");

        while (true) {

            System.out.print("Please enter your selection (1-4): ");

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


    private static boolean shouldDisplay(MenuOption option, Scanner scanner, dataCollection data) {
                switch (option) {
                        case VIEW:
                            System.out.println(data.listDataBase(FILE_NAME));
                            return true;
                        case ADOPT:
                            System.out.println("adopt");
                            return true;
                        case ADD:
                            System.out.println("add");
                            Dodo dod = new Dodo("Kiko", "Male", Date.valueOf("2021-04-18"), false, 4, "Healthy");
                            data.addToDataBase(dod);
                            return true;
                        case END:
                            return false;
                        default:
                            throw new IllegalArgumentException("Unexpected value: " + option);
                }
        }
}


