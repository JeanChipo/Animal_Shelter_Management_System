package model.animals.terrestrials.species;

import model.animals.AnimalDescription;
import model.animals.terrestrials.TerrestrialAnimal;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class BengalTiger extends TerrestrialAnimal implements AnimalDescription {
    private String specificites;

    public BengalTiger (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, "feline");
        this.specificites=null;
    }

    public BengalTiger (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, "feline");
        this.specificites=specificities;
    }

    public String description (){
        return "The Bengal tiger is a majestic and powerful big cat native to the Indian subcontinent. It is known for its striking orange coat with black stripes and is an apex predator in its habitat.";
    }

    public String getSpecificites() {
        return specificites;
    }

    public String toStore(){
        String export = "";
        List<Object> selfData = new ArrayList<>();
        selfData.add(this.getName());
        selfData.add(this.getAdress());
        selfData.add(this.getArrivalDate());
        selfData.add(this.isAdopted());
        selfData.add(this.getAge());
        selfData.add(this.getBloodType());
        selfData.add(this.getSubType());
        selfData.add(this.getSpecificites());
        for(Object data : selfData){
            if(data instanceof String){
                export+= data;
            }else{
                export+=data.toString();
            }
            export+="#";
        }
    }
}