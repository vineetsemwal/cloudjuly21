package com.example.customermsrest.controllers;

import com.example.customermsrest.exceptions.CustomerNotFoundException;
import com.example.customermsrest.exceptions.InvalidCustomerNameException;
import com.example.customermsrest.exceptions.UnsuccessfulCustomerAddException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    private static final Logger Log= LoggerFactory.getLogger(CentralizedExceptionHandler.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleCustomerNotFound(CustomerNotFoundException e) {
        Log.info("exception caught", e);
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCustomerNameException.class)
    public String handleInvalidCustomerNameException(InvalidCustomerNameException e){
        Log.info("exception caught", e);
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleViolationExceptionHandler(ConstraintViolationException e){
        Log.info("exception caught", e);
        return e.getMessage();
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLException.class)
    public String handleSqlException(SQLException e){
        Log.info("exception caught", e);
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnsuccessfulCustomerAddException.class)
    public String handleSqlException(UnsuccessfulCustomerAddException e){
        Log.info("exception caught", e);
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleAMyStupidThings(Exception e){
        Log.info("exception caught", e);
        return e.getMessage();
    }

}
