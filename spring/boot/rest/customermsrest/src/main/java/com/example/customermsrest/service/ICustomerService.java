package com.example.customermsrest.service;

import com.example.customermsrest.dao.CustomerDaoImpl;
import com.example.customermsrest.dto.CreateCustomerRequest;
import com.example.customermsrest.dto.CustomerDetails;
import com.example.customermsrest.dto.UpdateCustomerRequest;
import com.example.customermsrest.entities.Customer;

import java.util.List;

public interface ICustomerService {

    CustomerDetails add(CreateCustomerRequest request);

    CustomerDetails findCustomerDetailsById(Long id);

    CustomerDetails update(UpdateCustomerRequest request);

    void deleteById(Long id);

    List<CustomerDetails> findAll();
}
