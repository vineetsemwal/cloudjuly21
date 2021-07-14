package com.example.customermsrest.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}
