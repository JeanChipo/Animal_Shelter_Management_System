package model.animals.aerials.species;

import model.animals.AnimalDescription;
import model.animals.aerials.AerialAnimal;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Dodo extends AerialAnimal implements AnimalDescription {
    private String specificites;

    public Dodo (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, false);
        this.specificites=null;
    }

    public Dodo (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, false);
        this.specificites=specificities;
    }

    public String description (){
        return "The dodo is a flightless bird that was endemic to the island of Mauritius. It is known for its large size, distinctive appearance, and extinction in the late 17th century due to human activities. The dodo has become a symbol of extinct species and serves as a reminder of the importance of conservation efforts.";
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
        selfData.add(this.getCanFly());
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
