package com.example.customerms.dao;

import com.example.customerms.entities.Customer;

public  interface ICustomerDao {

    Customer add(Customer customer);

    Customer findById(Long id);

}
