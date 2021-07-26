package com.example.customermsrestdatajpa;

public class Calculator {

    Adder adder;
    public Calculator(Adder adder){
        this.adder=adder;
    }

    public int add(int a, int b){
        System.out.println("inside calculator add");
        int result=adder.add(a,b);
       return result;
    }

}
