package corejava.stringdemos;

public class SmallestString {
//expected aabbca
    public static void main(String[] args){
        SmallestString example=new SmallestString();
        String input="baacba";
        System.out.println("input="+input);
        String result=example.smallest(input);
        System.out.println("output="+result);
    }
    public  String smallest(String input){
     char []chars=input.toCharArray();
        for(int i=0;i<chars.length-1;i++){
                char currentChar = chars[i];
                char nextChar = chars[i + 1];
                if (currentChar == nextChar + 1) {
                    chars[i] = nextChar;
                    chars[i + 1] = currentChar;
                }
     }
        return new String(chars);
    }

}
