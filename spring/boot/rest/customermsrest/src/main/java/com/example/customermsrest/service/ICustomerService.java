package com.example.customermsrest.service;

import com.example.customermsrest.entities.Customer;

import java.util.List;

public  interface ICustomerService {

    Customer add(String name);

    Customer findById(Long id);

    Customer update(Customer customer);

    void deleteById(Long id);

    List<Customer> findAll();
}
