package com.example.customermsboot.dao;

import com.example.customermsboot.entities.Customer;

public  interface ICustomerDao {

    Customer add(Customer customer);

    Customer findById(Long id);

}
