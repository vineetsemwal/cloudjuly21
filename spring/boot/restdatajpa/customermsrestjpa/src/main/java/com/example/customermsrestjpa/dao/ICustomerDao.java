package com.example.customermsrestjpa.dao;

import com.example.customermsrestjpa.entities.Customer;

import java.util.List;

public  interface ICustomerDao {

    Customer add(Customer customer);

    Customer findById(Long id);

    Customer update(Customer customer);

    void deleteById(Long id);

    List<Customer> findAll();
}
