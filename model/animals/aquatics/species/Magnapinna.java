package model.animals.aquatics.species;

import model.animals.AnimalDescription;
import model.animals.aquatics.AquaticAnimal;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Magnapinna extends AquaticAnimal implements AnimalDescription {
    public String specificites;

    public Magnapinna(String name, String adress, Date arrivalDate, Date dateOfBirth, AnimalDescription description, boolean adopted, int age, String bloodType) {
        super(name, adress, arrivalDate, adopted, age, bloodType,false);
        this.specificites = null;
    }

    public Magnapinna(String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, false);
        this.specificites = specificities;
    }

    public String description(){
        return "A deep-sea squid known for its extremely long, thin arms and tentacles. It lives in the deep ocean and is rarely seen.";
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
        selfData.add(this.getScales());
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