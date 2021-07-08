package com.example.customerms.ui;

import com.example.customerms.entities.Customer;
import com.example.customerms.exceptions.CustomerNotFoundException;
import com.example.customerms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
/*
@Component
public class AppUi {

    @Autowired
    private ICustomerService service;

    @PostConstruct
    public void display() {
        System.out.println("***add customer");
        Customer customer = service.add("kalyan");
        display(customer);
        System.out.println("****find by id");
        long id = customer.getId();
        Customer fetchedCustomer = service.findById(id);
        display(fetchedCustomer);
    }

    void display(Customer customer) {
        System.out.println(customer.getId() + "-" + customer.getName());
    }
}
*/