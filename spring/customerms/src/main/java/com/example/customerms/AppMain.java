package com.example.customerms;

import com.example.customerms.entities.Customer;
import com.example.customerms.exceptions.CustomerNotFoundException;
import com.example.customerms.service.CustomerServiceImpl;
import com.example.customerms.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {


    private ICustomerService service;

    public static void main(String args[]) {
        AppMain app = new AppMain();
        app.start();

    }

    public void start() {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        service=context.getBean(ICustomerService.class);
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
