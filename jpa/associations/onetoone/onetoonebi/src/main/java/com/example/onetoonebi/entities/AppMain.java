package com.example.onetoonebi.entities;

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
        Address address = new Address("chennai", "55 A marina beach",null);
        em.persist(address);
        Long addressId=address.getId();

        Employee employee = new Employee("keerthna", address);
        em.persist(employee);
        Long empId=employee.getId();
        address.setEmployee(employee);

        transaction.commit();

        System.out.println("***employee fetched");
        Employee fetchedEmployee=em.find(Employee.class,empId);
        displayEmployee(fetchedEmployee);

        System.out.println("*** address fetcehd");
        Address fetchedAddress=em.find(Address.class, addressId);
        displayAddress(fetchedAddress);
        em.close();
        emf.close();


    }

    public void displayEmployee(Employee employee) {
        System.out.println("emp info "+employee.getId()+"-"+employee.getName());
        Address address = employee.getAddress();
        System.out.println("address info "+address.getId()+"-"+address.getCity()+"-"+address.getHouseInfo() );

    }


    public void displayAddress(Address address) {
        Employee employee = address.getEmployee();
        System.out.println("emp info "+employee.getId()+"-"+employee.getName());
        System.out.println("address info "+address.getId()+"-"+address.getCity()+"-"+address.getHouseInfo() );

    }

}
