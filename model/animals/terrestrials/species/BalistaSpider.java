package model.animals.terrestrials.species;

import model.animals.AnimalDescription;
import model.animals.terrestrials.TerrestrialAnimal;
import data.treatment.Storable;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class BalistaSpider extends TerrestrialAnimal implements AnimalDescription, Storable {
    private String specificites;

    public BalistaSpider (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, "arachnid");
        this.specificites = null;
    }

    public BalistaSpider (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, "arachnid");
        this.specificites = specificities;
    }

    public String description (){
        return "The Balista spider is a fascinating arachnid known for its unique hunting techniques and intricate web structures. It is a nocturnal predator that primarily feeds on insects.";
    }

    public String getSpecificites() {
        return specificites;
    }

    @Override 
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
        return export;
    }

}