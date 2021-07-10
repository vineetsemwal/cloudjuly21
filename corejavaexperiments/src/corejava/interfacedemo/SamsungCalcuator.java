package corejava.interfacedemo;

public class SamsungCalcuator implements ICalculator{

    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int sub(int num1, int num2) {
        return num1-num2;
    }
}
