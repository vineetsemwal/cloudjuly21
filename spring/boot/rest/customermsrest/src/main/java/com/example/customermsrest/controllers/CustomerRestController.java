package com.example.customermsrest.controllers;

import com.example.customermsrest.dto.CreateCustomerRequest;
import com.example.customermsrest.dto.CustomerDetails;
import com.example.customermsrest.dto.UpdateCustomerRequest;
import com.example.customermsrest.entities.Customer;
import com.example.customermsrest.exceptions.CustomerNotFoundException;
import com.example.customermsrest.exceptions.InvalidCustomerNameException;
import com.example.customermsrest.service.ICustomerService;
import com.example.customermsrest.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    public CustomerDetails fetchCustomer( @PathVariable("id") Long id) {
        CustomerDetails response = service.findCustomerDetailsById(id);
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
