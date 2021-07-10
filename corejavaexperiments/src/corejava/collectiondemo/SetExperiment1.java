package corejava.collectiondemo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetExperiment1 {

    public static void main(String[] args){
        SetExperiment1 experiment=new SetExperiment1();
        experiment.start();
    }

    public void  start(){
        Set<Employee> employees = new HashSet<>();
        Employee emp1 = new Employee(1,"hariprasath");
        Employee emp2=new Employee(2,"manikantha");
        Employee emp3=new Employee(3, "dewakar");
        employees.add(emp1);
        employees.add(emp3);
        employees.add(emp2);
        employees.add(emp2);
        displayEmployees(employees);
        int size=employees.size();
        System.out.println("size="+size);

    }


    void displayEmployee(Employee employee){
        System.out.println(employee.getId() +"-"+employee.getName());
    }

    void displayEmployees(Collection<Employee> employees){
        for (Employee emp:employees){
            displayEmployee(emp);
        }

    }

}
