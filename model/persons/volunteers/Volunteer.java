package model.persons.volunteers;

import model.persons.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Volunteer extends Person {
    private boolean availability;
    private Set<String> skills = new HashSet<>();
    private boolean assignmentStatus;

    public Volunteer(String id, int age, String adress, boolean availability, boolean assignmentStatus) {
        super(id, age, adress);
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
}

