package com.example.customerms.dao;

import com.example.customerms.entities.Customer;
import com.example.customerms.exceptions.CustomerNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CustomerDaoImpl implements ICustomerDao{

    // map has entries of id as key , Customer object as values
    private Map<Long,Customer> store=new HashMap<>();

    private long generatedId;

    public long newId(){
       return ++generatedId;
    }


    @Override
    public Customer add(Customer customer) {
       long id= newId();
        customer.setId(id);
        store.put(id, customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
       Customer customer =store.get(id);
       if(customer==null){
         throw new CustomerNotFoundException("customer not found for id="+id);
       }
       return customer ;
    }
}
