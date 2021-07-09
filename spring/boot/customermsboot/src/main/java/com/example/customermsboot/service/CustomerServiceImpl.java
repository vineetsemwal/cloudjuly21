package com.example.customermsboot.service;

import com.example.customermsboot.dao.ICustomerDao;
import com.example.customermsboot.entities.Customer;
import com.example.customermsboot.exceptions.InvalidCustomerIdException;
import com.example.customermsboot.exceptions.InvalidCustomerNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer add(String name) {
        validateName(name);
        Customer customer = new Customer();
        customer.setName(name);
        customer = dao.add(customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        validateId(id);
        Customer customer = dao.findById(id);
        return customer;
    }

    public void validateId(Long id){
        if(id==null || id<=0){
            throw new InvalidCustomerIdException("invalid customer id exception");
        }
    }

    public void validateName(String name){
        if (name == null || name.isEmpty()){
            throw new InvalidCustomerNameException("name can't be null or empty");
        }
    }
}
