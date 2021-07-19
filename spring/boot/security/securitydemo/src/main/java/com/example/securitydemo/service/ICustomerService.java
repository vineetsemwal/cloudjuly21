package com.example.securitydemo.service;

import com.example.securitydemo.dto.AddCustomerRequest;
import com.example.securitydemo.dto.CustomerDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ICustomerService {

    CustomerDetails add(@Valid @NotNull AddCustomerRequest request);

    CustomerDetails findCustomerDetailsById(Long id);

}
