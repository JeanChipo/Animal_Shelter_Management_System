package model.persons.volunteers;

import model.animals.Animal;
import model.persons.Person;

import java.util.*;

public class Volunteer extends Person {
    private boolean availability;
    private Set<String> skills = new HashSet<>();
    private boolean assignmentStatus;

    public Volunteer(String id, String name, int age, boolean availability, boolean assignmentStatus) {
        super(id, name, age);
        this.availability = availability;
        this.assignmentStatus = assignmentStatus;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public boolean containSkill(String skill) {
        return skills.contains(skill);
    }

    public void displaySkill() {
        Iterator<String> iterator = skills.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            String skill = iterator.next();
            System.out.println("Skill number " + count + " : " + skill);
            count++;
        }
    }

    public void display(){
        System.out.println("id : " + getId() + ", name : " + getName() + ", age : " + getAge() +
                ", availabilty : " + availability + ", assignement status : " + assignmentStatus + ", skills : ");
        displaySkill();
    }

    public boolean canTakeCare(Animal animal){
        Iterator<String> iterator = skills.iterator();
        boolean takeCare = false;
        while (iterator.hasNext()) {
            String skill = iterator.next();
            if (skill.equals(animal.getType()) && availability){
                takeCare = true;
                availability = false;
            }
        }
        return takeCare;
    }
}

