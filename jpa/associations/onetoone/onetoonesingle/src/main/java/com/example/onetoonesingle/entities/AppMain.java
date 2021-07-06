package com.example.onetoonesingle.entities;

import javax.persistence.*;

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
        Address address = new Address("chennai", "55 A marina beach");
        em.persist(address);

        Employee employee = new Employee("keerthna", address);
        em.persist(employee);
        transaction.commit();

        display(employee);

        em.close();
        emf.close();


    }

    public void display(Employee employee) {
        System.out.println("emp info "+employee.getId()+"-"+employee.getName());
        Address address = employee.getAddress();
        System.out.println("address info "+address.getId()+"-"+address.getCity()+"-"+address.getHouseInfo() );
    }

}
