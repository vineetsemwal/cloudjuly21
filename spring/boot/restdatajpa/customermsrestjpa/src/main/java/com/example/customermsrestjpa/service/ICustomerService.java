package com.example.customermsrestjpa.service;

import com.example.customermsrestjpa.dto.CreateCustomerRequest;
import com.example.customermsrestjpa.dto.CustomerDetails;
import com.example.customermsrestjpa.dto.UpdateCustomerRequest;
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
