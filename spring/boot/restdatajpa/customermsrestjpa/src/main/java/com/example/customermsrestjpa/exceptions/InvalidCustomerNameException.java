package com.example.customermsrestjpa.exceptions;

public class InvalidCustomerNameException extends RuntimeException{

    public InvalidCustomerNameException(String msg){
        super(msg);
    }

}
