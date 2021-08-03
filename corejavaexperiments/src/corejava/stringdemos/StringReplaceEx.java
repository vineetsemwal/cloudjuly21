package corejava.stringdemos;

public class StringReplaceEx {

    public static void main(String[] args){
        String names="meghna,kalyan,ashwin";
        //meghnaandkalyanandashwin
        String output=names.replace(",","and");
        System.out.println(output);
    }
}
