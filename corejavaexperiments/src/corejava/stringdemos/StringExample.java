package corejava.stringdemos;

public class StringExample {

    public static void main(String[] args){
        String input= "Arpit.MehtaID123456Annual80L";
        StringExample example=new StringExample();
         staticMethod(example);
    }

    public static void  staticMethod(StringExample example){
        example.findAndPrint("hello");
        
    }

    /**
     *
     *  FirstName=Arpit
     *  LastName=Mehta
     *  ID=123456
     *  AnnalPackage=80Lacs
     */
    public void findAndPrint(String input){
     int startDotIndex=input.indexOf(".");
      String firstName=input.substring(0,startDotIndex);
      System.out.println("FirstName="+firstName);
      int startIDIndex=input.indexOf("ID");
      String lastName=input.substring(startDotIndex+1,startIDIndex);
      System.out.println("LastName="+lastName);
      int idEndIndex=startIDIndex+2;
      int annualStartIndex=input.indexOf("Annual");
      String id=input.substring(idEndIndex,annualStartIndex);
      System.out.println("ID="+id);
      int annualEndIndex=annualStartIndex+"Annual".length();
      String annualPack=input.substring(annualEndIndex);
      int digitEndIndex=annualPack.length()-1;
      String packageDigits=annualPack.substring(0,digitEndIndex);
      System.out.println("AnnualPackage="+packageDigits+"Lacs");

    }

    /**
     *
     *  FirstName=Arpit,LastName=Mehta,ID=123456,AnnalPackage=80Lacs
     */

    public String convert(String input){
        int startDotIndex=input.indexOf(".");
        String firstName=input.substring(0,startDotIndex);
        String firstNameText="FirstName="+firstName;
        int startIDIndex=input.indexOf("ID");
        String lastName=input.substring(startDotIndex+1,startIDIndex);
        String lastNameText="LastName="+lastName;
        int idEndIndex=startIDIndex+2;
        int annualStartIndex=input.indexOf("Annual");
        String id=input.substring(idEndIndex,annualStartIndex);
        String idText="ID="+id;
        int annualEndIndex=annualStartIndex+"Annual".length();
        String annualPack=input.substring(annualEndIndex);
        int digitEndIndex=annualPack.length()-1;
        String packageDigits=annualPack.substring(0,digitEndIndex);
        String packageText="AnnualPackage="+packageDigits+"Lacs";
        String output=firstNameText+","+lastNameText+","+idText+","+packageText;
        return output;

    }
}
