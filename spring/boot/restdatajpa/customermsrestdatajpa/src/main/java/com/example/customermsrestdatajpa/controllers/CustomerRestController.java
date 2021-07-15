package com.example.customermsrestdatajpa.controllers;

import com.example.customermsrestdatajpa.dto.CreateCustomerRequest;
import com.example.customermsrestdatajpa.dto.CustomerDetails;
import com.example.customermsrestdatajpa.dto.UpdateCustomerRequest;
import com.example.customermsrestdatajpa.service.ICustomerService;
import com.example.customermsrestdatajpa.util.CustomerUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("customers")
@RequestMapping("/customers")
@RestController
public class CustomerRestController {

    @Autowired
    private ICustomerService service;

    @Autowired
    private CustomerUtil customerUtil;

    /**
     * /customers/byid/5
     */
    @GetMapping("/byid/{id}")
    public CustomerDetails fetchCustomerById( @PathVariable("id") Long id) {
        CustomerDetails response = service.findCustomerDetailsById(id);
        return response;

    }

    @GetMapping("/byname/{name}")
    public List<CustomerDetails>fetchByName(@PathVariable String name){
      List<CustomerDetails>response  =service.findCustomerDetailsByName(name);
      return response;
    }

    /**
     * /customers
     */
    @GetMapping
    public List<CustomerDetails> fetchAll() {
        List<CustomerDetails> response = service.findAll();
        return response;
    }

    /**
     * /customers/add
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails addCustomer(@RequestBody CreateCustomerRequest requestData) {
        CustomerDetails desired = service.add(requestData);
        return desired;
    }

    /**
     * /customers/update
     */
    @PutMapping("/update")
    public CustomerDetails updateCustomer(@RequestBody UpdateCustomerRequest requestData) {
        CustomerDetails response = service.update(requestData);
        return response;
    }


    @DeleteMapping("/delete/byid/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
        return "deleted customer with id=" + id;
    }


}
