package com.example.securitydemo.service;

import com.example.securitydemo.dto.AddCustomerRequest;
import com.example.securitydemo.dto.CustomerDetails;
import com.example.securitydemo.entities.AppUser;
import com.example.securitydemo.entities.Customer;
import com.example.securitydemo.exceptions.CustomerNotFoundException;
import com.example.securitydemo.repository.ICustomerRepository;
import com.example.securitydemo.repository.IUserRepository;
import com.example.securitydemo.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class CustomerServiceImpl  implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepo;

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private CustomerUtil customerUtil;

    @Override
    public CustomerDetails add(AddCustomerRequest request) {
        AppUser user=new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Set<String> roles=new HashSet<>();
        roles.add("CUSTOMER");
        user.setRoles(roles);
        user=userRepo.save(user);

        Customer customer=new Customer();
        customer.setUser(user);
        customer.setAmount(request.getAmount());
        customer=customerRepo.save(customer);
        CustomerDetails desired=customerUtil.toDetails(customer);
        return desired;
    }

    @Override
    public CustomerDetails findCustomerDetailsById(Long id) {
       Optional<Customer>optional= customerRepo.findById(id);
       if(!optional.isPresent()){
           throw new CustomerNotFoundException("customer not found for id="+id);
       }
       Customer customer=optional.get();
        CustomerDetails desired=customerUtil.toDetails(customer);
        return desired;
    }
}
