package com.example.manytoone.entities;

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

        Department softwareDev=new Department();
        softwareDev.setName("software development");
        em.persist(softwareDev);

        Department accountsDept=new Department();
        accountsDept.setName("accounts department");
        em.persist(accountsDept);

        Employee emp1 = new Employee("keerthna", softwareDev);
        em.persist(emp1);
        Employee  emp2=new Employee("abhro", softwareDev);
        em.persist(emp2);

        Employee emp3=new Employee("nioroshni",accountsDept);
        em.persist(emp3);

        transaction.commit();

        display(emp1);
        display(emp2);
        display(emp3);

        em.close();
        emf.close();


    }

    public void display(Employee employee) {
        System.out.println("emp info "+employee.getId()+"-"+employee.getName());
        Department dept=employee.getDepartment();
        System.out.println("department info "+dept.getId()+"-"+dept.getName() );
    }

}
