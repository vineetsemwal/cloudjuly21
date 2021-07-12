package com.example.customermsrest.service;

import com.example.customermsrest.dao.ICustomerDao;
import com.example.customermsrest.entities.Customer;
import com.example.customermsrest.exceptions.InvalidCustomerIdException;
import com.example.customermsrest.exceptions.InvalidCustomerNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public Customer update(Customer customer){
        customer=dao.update(customer);
       return customer;
    }

    @Override
    public void deleteById(Long id) {
         dao.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer>list=dao.findAll();
        return list;
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
