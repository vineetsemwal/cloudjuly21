package corejava.objectex;

public class Student {

    String firstName, lastName;

    public String getFirstName(){
        return firstName;
    }

   public String getLastName(){
        return lastName;
    }

    public String getFullName(){
        return getFirstName()+getLastName();
    }

}
