package model.animals.terrestrials.species;

import model.animals.AnimalDescription;
import model.animals.terrestrials.TerrestrialAnimal;

import java.util.Date;

public class JavaRhinoceros extends TerrestrialAnimal implements AnimalDescription {
    private String specificites;

    public JavaRhinoceros (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, "mammal");
        this.specificites = null;
    }

    public JavaRhinoceros (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, "mammal");
        this.specificites = specificities;
    }

    public String description (){
        return "The Javan rhinoceros is a critically endangered species of rhinoceros native to Indonesia. It is the rarest of the five rhino species and is known for its single horn and thick skin.";
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