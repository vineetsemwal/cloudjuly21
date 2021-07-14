package com.example.customermsrest.service;

import com.example.customermsrest.dao.CustomerDaoImpl;
import com.example.customermsrest.dto.CreateCustomerRequest;
import com.example.customermsrest.dto.CustomerDetails;
import com.example.customermsrest.dto.UpdateCustomerRequest;
import com.example.customermsrest.entities.Customer;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ICustomerService {

    CustomerDetails add(@NotNull @Valid CreateCustomerRequest request);

    CustomerDetails findCustomerDetailsById(@NotNull @Min(1) Long id);

    CustomerDetails update(@NotNull @Valid UpdateCustomerRequest request);

    void deleteById(@NotNull @Min(1) Long id);

    List<CustomerDetails> findAll();
}
