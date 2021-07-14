package com.example.customermsrestjpa.exceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String msg){
        super(msg);
    }

}
