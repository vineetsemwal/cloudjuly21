package com.example.jpademo1;


import com.example.jpademo1.entities.Trainee;

import javax.persistence.*;

public class TraineeMain1 {
    private EntityManager em;

    public static void main(String args[]) {
        TraineeMain1 app = new TraineeMain1();
        app.start();
    }

    /**
     * CRUD
     */
    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("training-ms");
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        System.out.println("****nethan added");
        Trainee nethan = new Trainee("nethan", 21);
        em.persist(nethan);
        transaction.commit();
        display(nethan);

        Long nethanId=nethan.getId();
        transaction=em.getTransaction();
        transaction.begin();
        System.out.println("****harini added");
        Trainee harini = new Trainee("harini", 20);
        em.persist(harini);
        transaction.commit();
        Long hariniId=harini.getId();
        System.out.println("******nethan's info fetched from id");
        Trainee fetchedNethan=em.find(Trainee.class,nethanId);
        display(fetchedNethan);
        Trainee fetcdedHarini=em.find(Trainee.class,hariniId);
        display(fetcdedHarini);

        em.close();
        emf.close();
    }

    public void display(Trainee trainee) {
        System.out.println("trainee " + trainee.getId() + " -" + trainee.getName() + "-" + trainee.getAge());
    }

}
