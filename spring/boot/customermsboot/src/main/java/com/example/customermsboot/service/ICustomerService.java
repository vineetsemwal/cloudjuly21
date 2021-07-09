package com.example.customermsboot.service;

import com.example.customermsboot.entities.Customer;

public  interface ICustomerService {

    Customer add(String name);

    Customer findById(Long id);

}
