package com.example.customerms.service;

import com.example.customerms.entities.Customer;

public  interface ICustomerService {

    Customer add(String name);

    Customer findById(Long id);

}
