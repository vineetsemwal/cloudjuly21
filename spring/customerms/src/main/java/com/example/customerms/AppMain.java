package com.example.customerms;

import com.example.customerms.entities.Customer;
import com.example.customerms.exceptions.CustomerNotFoundException;
import com.example.customerms.service.CustomerServiceImpl;
import com.example.customerms.service.ICustomerService;

public class AppMain {
    private ICustomerService service = new CustomerServiceImpl();

    public static void main(String args[]) {
       AppMain app = new AppMain();
       app.start();
    }

    public void start() {
        try {
            System.out.println("***add customer");
            Customer customer = service.add("kalyan");
            display(customer);
            System.out.println("****find by id");
            long id = 567;
            Customer fetchedCustomer = service.findById(id);
            display(fetchedCustomer);
        }catch(CustomerNotFoundException e){
           System.out.println(e.getMessage());
        }

        System.out.println("application finsihed, bye");

    }



    void display(Customer customer) {
        System.out.println(customer.getId() + "-" + customer.getName());
    }
}
