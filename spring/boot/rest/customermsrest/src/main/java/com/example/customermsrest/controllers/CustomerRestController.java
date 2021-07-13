package com.example.customermsrest.controllers;

import com.example.customermsrest.dto.CreateCustomerRequest;
import com.example.customermsrest.dto.CustomerDetails;
import com.example.customermsrest.dto.UpdateCustomerRequest;
import com.example.customermsrest.entities.Customer;
import com.example.customermsrest.service.ICustomerService;
import com.example.customermsrest.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public CustomerDetails fetchCustomer(@PathVariable("id") Long id) {
        Customer customer = service.findById(id);
        CustomerDetails response=customerUtil.toDetails(customer);
        return response;
    }

    /**
     *
     * /customers
     */
    @GetMapping
    public List<CustomerDetails> fetchAll(){
      List<Customer>list=  service.findAll();
      List<CustomerDetails>response= customerUtil.toDetailsList(list);
      return response;
    }

    /**
     *    /customers/add
     * */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails addCustomer(@RequestBody CreateCustomerRequest requestData){
       Customer customer =service.add(requestData.getName());
       CustomerDetails response=customerUtil.toDetails(customer);
        return response;
    }

    /**
     *
     *  /customers/update
     */
    @PutMapping("/update")
    public CustomerDetails updateCustomer(@RequestBody UpdateCustomerRequest requestData){
       Customer customer=service.findById(requestData.getId());
       customer.setName(requestData.getName());
       customer=service.update(customer);
       CustomerDetails response=customerUtil.toDetails(customer);
       return response;
    }


    @DeleteMapping("/delete/byid/{id}")
    public String deleteCustomer(@PathVariable Long id){
        service.deleteById(id);
        return "deleted customer with id="+id;
    }



}
