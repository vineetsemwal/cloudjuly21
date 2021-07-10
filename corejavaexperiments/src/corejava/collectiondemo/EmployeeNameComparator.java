package corejava.collectiondemo;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
       String name1= e1.getName();
       String name2=e2.getName();
       int comparison=name1.compareTo(name2);
       return comparison;
    }
}
