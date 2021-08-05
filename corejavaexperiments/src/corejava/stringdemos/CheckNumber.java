package corejava.stringdemos;

 public class CheckNumber{
 
 
  //'0'  and '9'
  
  public static void main(String args[]){
    CheckNumber checker=new CheckNumber();
    boolean result=checker.isStringNumber("12345a");
    System.out.println(result);
  }
  
  
   boolean isStringNumber(String input){
    
    for(int i=0;i<input.length();i++){
      char current=input.charAt(i);
      if(!(  current>='0' && current<='9' )){
      
       return false;
    }
    
   
   }
   
   return true;
 
 
 }
 
 }
