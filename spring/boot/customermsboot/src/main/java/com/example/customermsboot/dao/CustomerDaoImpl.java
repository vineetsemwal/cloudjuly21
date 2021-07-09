package com.example.customermsboot.dao;

import com.example.customermsboot.entities.Customer;
import com.example.customermsboot.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
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
