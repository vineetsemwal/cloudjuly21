package com.example.securitydemo.util;

import com.example.securitydemo.dto.CustomerDetails;
import com.example.securitydemo.entities.AppUser;
import com.example.securitydemo.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

   public CustomerDetails toDetails(Customer customer){
        CustomerDetails desired=new CustomerDetails();
        desired.setId(customer.getId());
        desired.setAmount(customer.getAmount());
        AppUser user=customer.getUser();
        desired.setUsername(user.getUsername());
        return desired;
    }

}
