package com.example.customermsrest.controllers;

import com.example.customermsrest.entities.Customer;
import com.example.customermsrest.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {

    @Autowired
    private ICustomerService service;

    /**
     * /customers/byid/5
     */
    @GetMapping("/byid/{id}")
    public Customer fetchCustomer(@PathVariable("id") Long id) {
        Customer customer = service.findById(id);
        return customer;
    }

    /**
     *
     * /customers
     */
    @GetMapping
    public List<Customer> fetchAll(){
      List<Customer>list=  service.findAll();
      return list;
    }

    /**
     *    /customers/add
     * */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer requestData){
       Customer response =service.add(requestData.getName());
        return response;
    }

    /**
     *
     *  /customers/update
     */
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer requestData){
       Customer response =service.update(requestData);
       return response;
    }


    @DeleteMapping("/delete/byid/{id}")
    public String deleteCustomer(@PathVariable Long id){
        service.deleteById(id);
        return "deleted customer with id="+id;
    }



}
