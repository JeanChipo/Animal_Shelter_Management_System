package model.animals;

import data.treatment.Storable;
import exception.WrongDataFormat;

import java.util.*;

public abstract class Animal {
    private int animalId;
    private String name;
    private String adress;
    private Date arrivalDate;
    private boolean adopted;
    private int age;
    private String bloodType;
    private String type;

    private static int animalCount = 0;

    public Animal(String name, String adress, Date arrivalDate, boolean adopted, int age, String bloodType, String type){
        this.animalId = animalCount++;
        this.name = name;
        this.adress = adress;
        this.arrivalDate = arrivalDate;
        this.adopted = adopted;
        this.age = age;
        this.bloodType = bloodType;
        this.type = type;
    }

    ///////////////////
    //INNER CLASS///
    /////////////////

    public class Stats implements Storable{
        private double speed;
        private String skin;
        private double strength;

        public Stats(double speed,String skin, double strength){
            this.speed = speed;
            this.skin = skin;
            this.strength = strength;
        }

        public String toStore() {
            return String.valueOf(speed)+"#"+skin+"#"+String.valueOf(strength);
        }

        public void toRead(String readableString) throws WrongDataFormat{
            List<String> readArgs = new ArrayList<String>(Arrays.asList(readableString.split("#")));
            if(readArgs.size()==3) {
                if (readArgs.get(0).matches("[-+]?[0-9]*\\.?[0-9]+") && readArgs.get(2).matches("[-+]?[0-9]*\\.?[0-9]+")) {
                    speed = Double.parseDouble(readArgs.get(0));
                    skin = readArgs.get(1);
                    strength = Double.parseDouble(readArgs.get(2));
                } else {
                    throw new WrongDataFormat("Wrong animal stats data format");
                }
            }else{
                throw new WrongDataFormat("Wrong animal stats data format");
            }
        }


        public class MedicalRecord implements Storable {
            private HashSet<String> vaccinations = new HashSet<>();
            private HashSet<String> treatments = new HashSet<>();
            private String notes;

            public String getNotes(){
                return this.notes;
            }

            public HashSet<String> getVaccinations(){
                return this.vaccinations;
            }

            public HashSet<String> getTreatments(){
                return this.treatments;
            }

            public void addVaccin(String vaccin){
                vaccinations.add(vaccin);
            }
            public void addTreatment(String treatment){
                vaccinations.add(treatment);
            }

            public void setNotes(String notes){
                this.notes=notes;
            }

            public String toStore(){
                String vaccinStr = vaccinations.toString();
                String treatmentStr = treatments.toString();
                return vaccinations + "#" + treatmentStr + "#" + notes;
            }

            public void toRead(String readableString) throws WrongDataFormat {
                List<String> readArgs = new ArrayList<String>(Arrays.asList(readableString.split("#")));
                if(readArgs.size()==3) {
                    for (int i = 0; i < 2; i++) {
                        if (readArgs.get(i).startsWith("[") && readArgs.get(i).endsWith("]")) {
                            String content = readArgs.get(i).substring(1, readArgs.get(i).length() - 1).trim();

                            if (!content.isEmpty()) {
                                String[] elems = content.split(", ");
                                if (i == 0) {
                                    this.vaccinations.addAll(Arrays.asList(elems));
                                } else {
                                    this.treatments.addAll(Arrays.asList(elems));
                                }

                            }
                        } else {
                            throw new WrongDataFormat("Wrong medical data format");
                        }
                    }
                }else{
                    throw new WrongDataFormat("Wrong medical data format");
                }
            }


    }

          ///////////////////
         //GETTERS STATS///
        /////////////////
        public double getSpeed(){
            return speed;
        }

        public String getSkin(){
            return skin;
        }

        public double getStrength(){
            return strength;
        }

    }

      ///////////////////
     //GETTERS ANIMAL///
    //////////////////
    public int getAnimalId(){
        return animalId;
    }

    public String getName(){
        return name;
    }

    public String getAdress(){
        return adress;
    }

    public Date getArrivalDate(){
        return arrivalDate;
    }

    public boolean isAdopted(){
        return adopted;
    }

    public int getAge(){
        return age;
    }

    public String getBloodType(){
        return bloodType;
    }

    public String getType(){
        return type;
    }

    public static int getAnimalCount(){
        return animalCount;
    }

    ///////////////////
    //SETTERS ANIMAL///
    //////////////////


    public void setName(String name){
        this.name = name;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    public void setArrivalDate(Date date){
        this.arrivalDate=date;
    }
    public void setAdoptedState(Boolean state){
        this.adopted=state;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setBloodType(String bloodType){
        this.bloodType=bloodType;
    }


    public abstract String toStore();
    public abstract void toRead(String readableStr);
}
