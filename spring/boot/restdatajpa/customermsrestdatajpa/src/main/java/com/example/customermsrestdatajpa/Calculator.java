package com.example.customermsrestdatajpa;

public class Calculator {

    Adder adder;

    public void setAdder(Adder adder){
        this.adder=adder;
    }

    public int add(int a, int b){
        System.out.println("inside calculator add");
        int result=adder.add(a,b);
        System.out.println(adder+"result="+result);
       return result;
    }

}
