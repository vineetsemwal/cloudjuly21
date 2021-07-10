package corejava.listdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListExperiment2 {

    public static void main(String args[]) {
        ListExperiment2 experiment=new ListExperiment2();
        experiment.start();
    }

    public void start() {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(1, "keerthana");
        Employee emp2 = new Employee(2, "ashwin");
        Employee emp3 = new Employee(3, "kalyan");
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        Employee emp22 = new Employee(2, "ashwin");
        boolean exist = list.contains(emp22);
        System.out.println(exist);

        displayEmployees(list);


        System.out.println("***fetch and display element at index 1");
        Employee fetched=list.get(1);
        displayEmployee(fetched);

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
