package com.example.customermsrest.dao;

import com.example.customermsrest.entities.Customer;
import com.example.customermsrest.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

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
        LocalDate today=LocalDate.now();
        customer.setCreatedDate(today);
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

    @Override
    public Customer update(Customer customer){
        store.put(customer.getId(), customer);
         return customer;
    }

    @Override
    public void deleteById(Long id){
        store.remove(id);
    }

    @Override
    public List<Customer> findAll(){
       Collection<Customer> customers= store.values();
       List<Customer>list=new ArrayList<>(customers);
       return list ;
    }
}
