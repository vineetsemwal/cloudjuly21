package corejava.collectiondemo;

public class Employee {

    private int id,age ;

    private String name;


    public Employee() {
    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Employee emp1=new Employee(1,"suganthi");//1
     * String emp2="cyx"; // 1
     * boolean isEquals=emp1.equals(emp2)
     */
    @Override
    public boolean equals(Object arg) {
        if (this == arg) {
            return true;
        }
        if (arg == null || !(arg instanceof Employee)) {
            return false;
        }
        Employee that = (Employee) arg;
        boolean equals = this.id == that.id;
        return equals;
    }

    @Override
    public int hashCode() {
        return id;
    }


}
