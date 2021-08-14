package com.example.customermsrest.exceptions;

public class UnsuccessfulCustomerAddException extends RuntimeException{
    public UnsuccessfulCustomerAddException(String msg){
        super(msg);
    }
    public UnsuccessfulCustomerAddException(String msg, Throwable cause){
        super(msg, cause);
    }

}
