package com.example.customermicroservice.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}
