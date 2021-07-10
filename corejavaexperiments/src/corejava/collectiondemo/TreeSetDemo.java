package corejava.collectiondemo;

import java.util.*;

public class TreeSetDemo {

    public static void main(String args[]){
        TreeSetDemo demo=new TreeSetDemo();
        demo.start();
    }

    public  void start(){
        //Comparator<Employee> comparator=new EmployeeAgeComparator();
        Comparator<Employee> comparator=new EmployeeNameComparator();

        Set<Employee> employees = new TreeSet<>();
        Employee emp1 = new Employee(1,"hariprasath", 23);
        Employee emp2=new Employee(2,"manikantha",21);
        Employee emp3=new Employee(3, "dewakar",22);
        employees.add(emp1);
        employees.add(emp3);
        employees.add(emp2);
        displayEmployees(employees);
        int size=employees.size();
        System.out.println("size="+size);

    }



    void displayEmployee(Employee employee){
        System.out.println(employee.getId() +"-"+employee.getName()+"-"+employee.getAge());
    }

    void displayEmployees(Collection<Employee> employees){
        for (Employee emp:employees){
            displayEmployee(emp);
        }

    }

}
