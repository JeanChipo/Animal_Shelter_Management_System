package model.animals;

import java.util.Date;

public abstract class Animal {
    private int animalId;
    private String name;
    private String adress;
    private Date arrivalDate;
    private boolean adopted;
    private int age;
    private String bloodType;
    private String type;

    private static int animalCount = 0;

    public Animal(String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String type){
        this.animalId = animalCount++;
        this.name = name;
        this.adress = adress;
        this.arrivalDate = arrivalDate;
        this.adopted = adopted;
        this.age = age;
        this.bloodType = bloodType;
        this.type = type;
    }

    public class Stats{
        private double speed;
        private String skin;
        private double strength;

        public Stats(double speed,String skin, double strength){
            this.speed = speed;
            this.skin = skin;
            this.strength = strength;
        }
    }

}
