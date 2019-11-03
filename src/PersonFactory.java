public class PersonFactory {


    public static Person create(String role, String nom){

        Person newPerson = null;
        if(role.equals("CONF")){
            return new Conference(nom);
        }
        else if (role.equals("DEEP DIVE")){
            return new DeepDive(nom);
        }
        else if (role.equals("TRINGA")){
            return new Tringa(nom);
        }
        else if (role.equals("SPEAKER")){
            return new Speaker(nom);
        }
        else if (role.equals("STAFF")){
            return new Staff(nom);
        }
        else return null;

    }
}
