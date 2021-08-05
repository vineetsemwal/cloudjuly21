package corejava.stringdemos;

import java.util.*;



public class Checker2{

public static void main(String [] args){

 Checker2 checker=new Checker2();
 boolean result=checker.check("door");
 
 System.out.println(result);
}

//character are between and z
public boolean check(String input){

   Set<String>found= new HashSet<>();    

   for(int i=0;i<input.length();i++){
      char currentChar=input.charAt(i);
      if(currentChar>= 'a' && currentChar<='z'){
       found.add(""+currentChar);
       
      }      
   }
   
   return (found.size()>=2);

} 

}
