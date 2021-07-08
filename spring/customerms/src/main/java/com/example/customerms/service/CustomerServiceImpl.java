package com.example.customerms.service;

import com.example.customerms.dao.CustomerDaoImpl;
import com.example.customerms.dao.ICustomerDao;
import com.example.customerms.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer add(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        customer = dao.add(customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = dao.findById(id);
        return customer;
    }
}
