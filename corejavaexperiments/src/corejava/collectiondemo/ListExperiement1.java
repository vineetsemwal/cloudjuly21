package corejava.collectiondemo;

import java.util.*;

public class ListExperiement1 {

    public static void main (String args[]){
       ListExperiement1 experiement=new ListExperiement1();
       experiement.start();

    }

    public void  start(){
        List<String> list=new ArrayList<>();
        list.add("meghna");
        list.add("hariprasath");
        list.add("kalyan");
        list.add("keerthana");

        String fetched=list.get(1);
        System.out.println("size before removal "+list.size());
        list.remove(2);
        System.out.println("size after removal "+ list.size());

        list.add(0,"kalyan");
        System.out.println("size after insertion "+ list.size());

        list.set(0,"sai kalyan");

        display(list);

        List<String>newNames=new ArrayList<>();
        newNames.add("ashwin");
        newNames.add("suganthi");
        newNames.add("nethan");


        list.addAll(newNames);
        display(list);


        List<String>removeUS=new ArrayList<>();
        removeUS.add("meghna");
        removeUS.add("nethan");


        list.removeAll(removeUS);
        System.out.println("*** after removing elements");
        display(list);

        boolean exists=list.contains("ashwin");
        System.out.println("exists ="+exists);

        List<String>checkUs=new ArrayList<>();
        checkUs.add("ashwin");
        checkUs.add("keerthana");
        boolean existAll=list.containsAll(checkUs);
        System.out.println("existall="+existAll);
    }



    void display(Collection<String> names){
        for (String name:names){
            System.out.println("name="+name);
        }

    }


}
