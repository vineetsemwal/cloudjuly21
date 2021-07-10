package corejava.listdemo;

import java.util.*;

public class ListExperiement {

    public static void main (String args[]){
       ListExperiement experiement=new ListExperiement();
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

    }



    void display(Collection<String> names){
        for (String name:names){
            System.out.println("name="+name);
        }

    }


}
