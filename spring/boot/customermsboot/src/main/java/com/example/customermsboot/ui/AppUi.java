package com.example.customermsboot.ui;

import com.example.customermsboot.entities.Customer;
import com.example.customermsboot.exceptions.CustomerNotFoundException;
import com.example.customermsboot.exceptions.InvalidCustomerIdException;
import com.example.customermsboot.exceptions.InvalidCustomerNameException;
import com.example.customermsboot.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppUi {

    @Autowired
    private ICustomerService service;


    public void runUi() {
        try {
            System.out.println("***add customer");
            Customer customer = service.add("kalyan");
            display(customer);
            System.out.println("****find by id");
            long id = customer.getId();
            Customer fetchedCustomer = service.findById(id);
            display(fetchedCustomer);
        }catch(InvalidCustomerIdException e){
            String msg=e.getMessage();
            System.out.println(msg);
        }
        catch(InvalidCustomerNameException e){
            String msg=e.getMessage();
            System.out.println(msg);
        }
        catch(CustomerNotFoundException e){
            String msg=e.getMessage();
            System.out.println(msg);
        }
    }

    void display(Customer customer) {
        System.out.println(customer.getId() + "-" + customer.getName());
    }
}