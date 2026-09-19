package test;

import model.animals.Animal;
import model.animals.aerials.species.Dodo;
import model.persons.Person;
import model.persons.volunteers.Volunteer;
import service.CareTask;

import java.sql.Date;

public class Test {
    public static void main(String args[]){
        Animal dodo = new Dodo("Roger","Corbeille Essonne", Date.valueOf("2026-10-18"),false,19,"B20","breath fire");
        Volunteer volunteer1 = new Volunteer("V-1", "Damien", 23, true);
        CareTask.takeCare(volunteer1,dodo);
        volunteer1.addSkill("Aerial");
        volunteer1.displaySkill();
        CareTask.takeCare(volunteer1,dodo);
        CareTask.displayCare();


    }
}
