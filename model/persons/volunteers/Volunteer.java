package model.persons.volunteers;

import model.persons.Person;

public class Volunteer extends Person {
    private boolean availability;
    private String skills;
    private boolean assignmentStatus;

    public Volunteer(String id, int age, String adress, boolean availability, String skills, boolean assignmentStatus){
        super(id,age,adress);
        this.availability = availability;
        this.skills = skills;
        this.assignmentStatus = assignmentStatus;
    }
}
