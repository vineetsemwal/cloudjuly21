package com.example.customermsrest.service;

import com.example.customermsrest.dao.ICustomerDao;
import com.example.customermsrest.dto.CreateCustomerRequest;
import com.example.customermsrest.dto.CustomerDetails;
import com.example.customermsrest.dto.UpdateCustomerRequest;
import com.example.customermsrest.entities.Customer;
import com.example.customermsrest.exceptions.InvalidCustomerIdException;
import com.example.customermsrest.exceptions.InvalidCustomerNameException;
import com.example.customermsrest.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    @Autowired
    private CustomerUtil customerUtil;

    @Override
    public CustomerDetails add(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer = dao.add(customer);
        CustomerDetails desired = customerUtil.toDetails(customer);
        return desired;
    }

    public Customer findById(Long id) {
        validateId(id);
        Customer customer = dao.findById(id);
        return customer;
    }

    @Override
    public CustomerDetails findCustomerDetailsById(Long id) {
        Customer customer = findById(id);
        CustomerDetails desired = customerUtil.toDetails(customer);
        return desired;
    }

    @Override
    public CustomerDetails update(UpdateCustomerRequest request) {
        Customer customer = findById(request.getId());
        customer.setName(request.getName());
        customer = dao.update(customer);
        CustomerDetails response = customerUtil.toDetails(customer);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }


    @Override
    public List<CustomerDetails> findAll() {
        List<Customer> list = dao.findAll();
        List<CustomerDetails>desired=customerUtil.toDetailsList(list);
        return desired;
    }

    public void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidCustomerIdException("invalid customer id exception");
        }
    }

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidCustomerNameException("name can't be null or empty");
        }
    }
}
