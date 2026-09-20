package model.animals.aerials.species;

import exception.WrongDataFormat;
import model.animals.Animal;
import model.animals.AnimalDescription;
import model.animals.aerials.AerialAnimal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Chiken extends AerialAnimal implements AnimalDescription {
    private String specificites;

    public Chiken (String readableStr){
        super("","",new Date(),false,0,"",false);
        this.toRead(readableStr);
    }

    public Chiken (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, false);
        this.specificites=null;
    }

    public Chiken (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, false);
        this.specificites=specificities;
    }

    public String description (){
        return "The chicken is a domesticated bird that is widely kept for its meat and eggs. It is known for its distinctive clucking sound, feathered body, and ability to lay eggs regularly. Chickens are social animals that can be found in various breeds, each with unique characteristics and appearances.";
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
        export=export.substring(0,export.length()-1);
        return export;
    }
    public void toRead(String readableString) throws WrongDataFormat{
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
            this.setCanFly(Boolean.parseBoolean(readArgs.get(6)));
            this.specificites= readArgs.get(7);
        }else{
            throw new WrongDataFormat("Wrong animal data format");
        }
    }

}

