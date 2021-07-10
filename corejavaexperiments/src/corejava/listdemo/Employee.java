package corejava.listdemo;

import java.util.Objects;

public class Employee {

    private int id;

    private String name;

    public Employee(){}

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Employee emp1=new Employee(1,"suganthi");
     *   Employee emp2=new Employee(1,"suganthi")
     *  boolean isEquals=emp1.equals(emp2)
     *
     */

    @Override
    public boolean equals(Object  arg){
        if(this==arg){
            return true;
        }
        if(arg==null||  !(arg instanceof Employee) ){
            return false;
        }
        Employee that=(Employee)arg;
        boolean equals=this.id==that.id;
        return equals;
    }

}
