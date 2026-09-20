package model.animals.terrestrials.species;

import exception.WrongDataFormat;
import model.animals.AnimalDescription;
import model.animals.terrestrials.TerrestrialAnimal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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

    public void toRead(String readableString) throws WrongDataFormat {
        List<String> readArgs = new ArrayList<String>(Arrays.asList(readableString.split("#")));
        if(readArgs.size()==8) { //8 elements
            this.setName(readArgs.getFirst());
            this.setAdress(readArgs.get(1));
            this.setArrivalDate(new Date());
            this.setAdoptedState(Boolean.parseBoolean(readArgs.get(3)));
            if(readArgs.get(4) != null && readArgs.get(4).trim().matches("[-+]?\\d+")){
                this.setAge(Integer.parseInt(readArgs.get(4)));
            }else{
                throw new WrongDataFormat("Wrong animal data format");
            }
            this.setBloodType(readArgs.get(5));
            this.setSubType(readArgs.get(6));
            this.specificites= readArgs.get(7);
        }else{
            throw new WrongDataFormat("Wrong animal data format");
        }
    }

}