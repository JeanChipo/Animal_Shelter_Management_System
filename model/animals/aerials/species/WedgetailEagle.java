package model.animals.aerials.species;

import exception.WrongDataFormat;
import model.animals.AnimalDescription;
import model.animals.aerials.AerialAnimal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class WedgetailEagle extends AerialAnimal implements AnimalDescription {
    private String specificites;

    public WedgetailEagle (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType){
        super(name, adress, arrivalDate, adopted, age, bloodType, true);
        this.specificites=null;
    }

    public WedgetailEagle (String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String specificities){
        super(name, adress, arrivalDate, adopted, age, bloodType, true);
        this.specificites=specificities;
    }

    public String description (){
        return "The wedge-tailed eagle is a large bird of prey native to Australia and parts of New Guinea. It is known for its distinctive wedge-shaped tail, which gives it its name. These eagles are powerful hunters, capable of taking down a variety of prey, including mammals, birds, and reptiles. They are also known for their impressive soaring abilities and can often be seen gliding high in the sky. Wedge-tailed eagles are an iconic species in Australia and are often associated with the country's wilderness and natural beauty.";
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
            this.setCanFly(Boolean.parseBoolean(readArgs.get(6)));
            this.specificites= readArgs.get(7);
        }else{
            throw new WrongDataFormat("Wrong animal data format");
        }
    }

}
