package com.example.customermsrest.dao;

import com.example.customermsrest.entities.Customer;
import com.example.customermsrest.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.*;

@Repository
public class CustomerDaoImpl implements ICustomerDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer add(Customer customer) {
        LocalDate today=LocalDate.now();
        customer.setCreatedDate(today);
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
       Customer customer = entityManager.find(Customer.class,id);
       if(customer==null){
         throw new CustomerNotFoundException("customer not found for id="+id);
       }

       return customer ;
    }

    @Override
    public Customer update(Customer customer){
        customer= entityManager.merge(customer);
         return customer;
    }

    @Override
    public void deleteById(Long id){
      Customer customer= findById(id);
      entityManager.remove(customer);
    }

    @Override
    public List<Customer> findAll(){
       TypedQuery query =entityManager.createQuery("from Customer", Customer.class);
       List<Customer>list= query.getResultList();
       return list ;
    }
}
