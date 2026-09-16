package model.animals.terrestrials.species;

import model.animals.AnimalDescription;
import model.animals.terrestrials.TerrestrialAnimal;

import java.util.Date;

public class BalistaSpider extends TerrestrialAnimal implements AnimalDescription {
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

    public String toStore(){
        String export = "";
        List<Object> selfData = new ArrayList<>();
        selfData.add(this.getName());
        selfData.add(this.getAdress());
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