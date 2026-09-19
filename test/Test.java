package test;

import model.animals.Animal;
import model.animals.aerials.species.Dodo;
import model.animals.aquatics.species.MantisShrimp;
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
        Animal mantisShrimp = new MantisShrimp("Théodule","Evry",Date.valueOf("2024-08-12"),false,56,"Pedophile","Peacock Shrimp");
        CareTask.takeCare(volunteer1,mantisShrimp);
        volunteer1.addSkill("Aquatic");
        CareTask.takeCare(volunteer1,mantisShrimp);
        Volunteer volunteer2 = new Volunteer("V-2", "Thomas", 32, true);
        volunteer2.addSkill("Aquatic");
        CareTask.takeCare(volunteer2,mantisShrimp);
        CareTask.displayCare();
        volunteer1.display();
        volunteer2.display();
    }
}
