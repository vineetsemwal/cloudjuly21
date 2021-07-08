package com.example.customerms.ui;

import com.example.customerms.entities.Customer;
import com.example.customerms.exceptions.CustomerNotFoundException;
import com.example.customerms.exceptions.InvalidCustomerIdException;
import com.example.customerms.exceptions.InvalidCustomerNameException;
import com.example.customerms.service.ICustomerService;
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