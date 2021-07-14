package com.example.customermsrest.exceptions;

public class InvalidCustomerNameException extends RuntimeException{

    public InvalidCustomerNameException(String msg){
        super(msg);
    }

}
