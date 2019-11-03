import java.util.ArrayList;


public class Hotel {

    int i1=1;
    int i2=101;
    int i3=201;
    int time=0;

    int standard;
    int suites;
    int apartements;
    Event event;

    protected ArrayList<Person>persons;

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public Hotel(int standard, int suites, int apartements) {
        this.standard = standard;
        this.suites = suites;
        this.apartements = apartements;
    }


    public String getRoomFor(String nom) {
        for (Person person : persons) {
            if (person.getNom().equals(nom)) {
                return person.getRoom();

            }
        }
        return "";
    }


    public void giveRoom(String nom,int remainingRooms){


        for(Person person: persons) {
            if (person.getNom().equals(nom)) {


                if (person.getRole().equals("SPEAKER")) {
                    suites = suites - 1;
                    i2++;

                    person.setRoom("Suite N°" + (i2-1));



                }



                else {
                    if (standard != 0 && standard >=remainingRooms) {
                        if (person.getRole().equals("CONF")) {
                            standard = standard - 1;
                            remainingRooms--;
                            i1++;
                            time++;

                            person.setRoom("Standard room N°" + (i1-1));



                        }
                        else if (person.getRole().equals("DEEP DIVE") && time>=1) {

                            person.setRoom("Standard room N°" + (i1-1));



                        }
                        else {
                            standard = standard - 1;
                            remainingRooms--;
                            i1++;
                            person.setRoom("Standard room N°" + (i1-1));


                        }







                    } else if (remainingRooms<=apartements){
                        apartements = apartements - 1;
                        remainingRooms--;
                        i3++;

                        person.setRoom("Apart N°" + (i3-1));



                    }
                }

            }
        }
    }
    public String checkAvailibility(){
        return "Standard rooms: "+standard+"|Suites: "+suites+"|Aparts: "+apartements;

    }



}
