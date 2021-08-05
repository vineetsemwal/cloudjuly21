package corejava.stringdemos;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VowelCheck {

    public static void main(String args[]){
        VowelCheck checker=new VowelCheck();
        boolean result=checker.checkVowel("are");
        System.out.println(result);
    }

    public boolean checkVowel(String input){

        List<String> list= Arrays.asList("a","e","i","o","u");
        Set<String>found=new HashSet<>();
        for (int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            String chStr=""+ch;
            boolean contains=list.contains(chStr);
            if(contains){
             found.add(chStr);
            }
        }
        System.out.println("found="+found);

        return found.size()>=2;
    }

}
