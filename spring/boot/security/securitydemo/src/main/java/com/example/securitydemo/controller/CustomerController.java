package com.example.securitydemo.controller;

import com.example.securitydemo.dto.AddCustomerRequest;
import com.example.securitydemo.dto.CustomerDetails;
import com.example.securitydemo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @PostMapping("/p/add")
    public CustomerDetails add(@RequestBody AddCustomerRequest request){
        return service.add(request);
    }



}
