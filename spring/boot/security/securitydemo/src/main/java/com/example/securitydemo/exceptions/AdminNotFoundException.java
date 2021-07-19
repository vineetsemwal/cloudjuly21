package com.example.securitydemo.exceptions;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(String  msg){
        super(msg);
    }


}
