package corejava.collectiondemo;

import java.util.*;

public class MapExample2 {

    public static void main(String args[]) {
        MapExample2 example = new MapExample2();
        example.start();
    }

    public void start() {
        Comparator<Integer> comparator = new EmployeeIdComparator();
        Map<Integer, Employee> map = new TreeMap<>(comparator);
        Employee emp1 = new Employee(1, "chandu", 21);
        Employee emp2 = new Employee(2, "harini", 22);
        Employee emp3 = new Employee(3, "meghana", 23);
        map.put(emp1.getId(), emp1);
        map.put(emp3.getId(), emp3);
        map.put(emp2.getId(), emp2);
        int size = map.size();
        System.out.println("size before removal=" + size);

        //map.remove(3);
        Set<Integer> keys = map.keySet();

        System.out.println("** iterating on keys");
        for (int id : keys) {
            Employee value = map.get(id);
            System.out.print("key=" + id+"-");
            displayEmployee(value);
        }

        System.out.println("*** iterating on values ");
        Collection<Employee> employees = map.values();
        for (Employee emp : employees) {
            displayEmployee(emp);
        }

    }


    void displayEmployee(Employee employee) {
        System.out.println(employee.getId() + "-" + employee.getName());
    }

    void displayEmployees(Collection<Employee> employees) {
        for (Employee emp : employees) {
            displayEmployee(emp);
        }

    }


}

