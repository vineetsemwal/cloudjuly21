package com.example.manytoonebi;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

        Employee emp3=new Employee("nioroshni", accountsDept);
        em.persist(emp3);

        Set<Employee> softwareDevEmployees=new HashSet<>();
        softwareDevEmployees.add(emp1);
        softwareDevEmployees.add(emp2);
        softwareDev.setEmployees(softwareDevEmployees);

        Set<Employee>accountEmployees=new HashSet<>();
        accountEmployees.add(emp3);
        accountsDept.setEmployees(accountEmployees);

        transaction.commit();

        System.out.println("**displaying employees and their departments");
        
         displayEmployee(emp1);
         displayEmployee(emp2);
         displayEmployee(emp3);
        
        
         System.out.println("** displaying departments and their employees");
        displayDepartment(softwareDev);
        displayDepartment(accountsDept);

        em.close();
        emf.close();


    }

    public void displayEmployee(Employee employee) {
        System.out.println("emp info "+employee.getId()+"-"+employee.getName());
        Department dept=employee.getDept();
        System.out.println("dept is "+dept.getId()+"-"+dept.getName());
    }

    public void displayDepartment(Department department){
        System.out.println("department-"+department.getId()+"-"+department.getName());
        Set<Employee>employees=department.getEmployees();
        for(Employee employee:employees){
            displayEmployee(employee);
        }

    }

}
