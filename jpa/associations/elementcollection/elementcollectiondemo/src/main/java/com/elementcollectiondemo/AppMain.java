package com.elementcollectiondemo;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

public class AppMain {
    private EntityManager em;

    public static void main(String args[]) {
        AppMain app = new AppMain();
        app.runProject();
    }

    public void runProject() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("training-ms");
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Cart cart1=new Cart();
        cart1.setUserId(51l);
        Map<Long, Integer>cart1Items=new HashMap<>();
        cart1Items.put(1l,10);
        cart1Items.put(2l,15);
        cart1Items.put(3l,16);
        cart1.setItems(cart1Items);


        em.persist(cart1);


        Cart cart2=new Cart();
        cart2.setUserId(65l);
        Map<Long, Integer>cart2Items=new HashMap<>();
        cart2Items.put(1l,5);
        cart2Items.put(6l,2);
        cart2Items.put(3l,5);
        cart2.setItems(cart2Items);

        em.persist(cart2);

        transaction.commit();


        em.close();
        emf.close();


    }




}
