package corejava.interfacedemo;

public class CalculatorMain {

    public static void main(String args[]){
        ICalculator calculator=new CasioCalculator();
        int addResult=calculator.add(10,20);
        int subResult=calculator.sub(10,5);

        System.out.println("add result="+addResult);
        System.out.println("sub result="+subResult);
    }
}
