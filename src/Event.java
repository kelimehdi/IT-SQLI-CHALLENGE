import java.util.ArrayList;




public class Event {
    Hotel hotel;
    ArrayList<Person>persons;





    public Event(Hotel hotel) {
        persons=new ArrayList<>();
        hotel.setPersons(persons);
        this.hotel= hotel;

    }

    public void print() {
        for (Person person: persons) {
            System.out.println(person.getNom() + " " + person.getRole());
        }
    }

    public boolean register(String role , String ... noms ){

      boolean cree=false;
        for(String nom:noms){
            if(SearchName(nom)==false){
                persons.add(PersonFactory.create(role,nom));
                hotel.giveRoom(nom,noms.length);
                cree=true;

            }

        }
        return cree;
    }


    public boolean SearchName(String nom){
        boolean existe=false;
        for(Person person:persons){
            if (person.getNom().equals(nom)){
                existe=true;
            }

        }
        return existe;

    }
}
