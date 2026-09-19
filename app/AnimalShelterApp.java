package app;

import data.treatment.*;;

public class AnimalShelterApp {
    public static void main(String[] args) {
        dataTester dt = new dataTester("data/treatment/DataBase.txt");
        dt.test();
    }
}