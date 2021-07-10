package corejava.collectiondemo;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {

    /**
     *
     *  e1> e2   return +ve
     *  e1<e2   return  -ve
     *  e1 equals e2 return 0
     *
     */
    @Override
    public int compare(Employee e1, Employee e2) {
       int comparison=e1.getAge() - e2.getAge();
        return comparison;
    }
}
