package com.example.jpademo1;


import com.example.jpademo1.entities.Trainee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TraineeMain2 {
    private EntityManager em;

    public static void main(String args[]) {
        TraineeMain2 app = new TraineeMain2();
        app.start();
    }

    /**
     * CRUD
     */
    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("training-ms");
        em = emf.createEntityManager();
        System.out.println("****nethan added");
        Trainee nethan = new Trainee("nethan", 21);
        add(nethan);
        Long nethanId = nethan.getId();
        System.out.println("****harini added");
        Trainee harini = new Trainee("harini", 20);
        add(harini);
        Long hariniId = harini.getId();

        System.out.println("***update name");
        updateName(hariniId,"hareeni");

        System.out.println("******nethan's info");
        Trainee fetchedNethan = em.find(Trainee.class, nethanId);
        display(fetchedNethan);

        System.out.println("******harinis info ");
        Trainee fetcdedHarini = em.find(Trainee.class, hariniId);
        display(fetcdedHarini);

        System.out.println("****** deleting harinis record in table");
        remove(hariniId);

        em.close();
        emf.close();
    }

    public void add(Trainee trainee) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        System.out.println("****trainee added");
        em.persist(trainee);
        transaction.commit();
    }

    public void updateName(Long id, String newName) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Trainee trainee = em.find(Trainee.class, id);
        trainee.setName(newName);
        //
        // 1) updates the existing row in table  1 , harini
         // trainee --- id null
        // 2) Can insert a new row
        //
        trainee=em.merge(trainee);
        transaction.commit();
    }

    public void remove(Long id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Trainee trainee=em.find(Trainee.class,id);
        em.remove(trainee);
        transaction.commit();
    }

    public void display(Trainee trainee) {
        System.out.println("trainee " + trainee.getId() + " -" + trainee.getName() + "-" + trainee.getAge());
    }

}
