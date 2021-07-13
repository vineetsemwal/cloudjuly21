package com.example.customermsrest.util;

import com.example.customermsrest.dto.CustomerDetails;
import com.example.customermsrest.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

    public CustomerDetails toDetails(Customer customer){
        CustomerDetails desired=new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        return desired;
    }

}
