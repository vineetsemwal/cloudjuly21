package com.example.customerms.service;

import com.example.customerms.dao.CustomerDaoImpl;
import com.example.customerms.dao.ICustomerDao;
import com.example.customerms.entities.Customer;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao dao = new CustomerDaoImpl();

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
