package com.example.customermsrestjpa.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}
