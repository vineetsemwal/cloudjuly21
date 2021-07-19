package com.example.securitydemo.service;

import com.example.securitydemo.dto.CustomerUserDetails;
import com.example.securitydemo.entities.AppUser;
import com.example.securitydemo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("***** inside loadUserByUsername, username="+username);
        AppUser user= repository.findUserByUsername(username);
        CustomerUserDetails userDetails=new CustomerUserDetails(user);
        System.out.println("user ="+user.getUsername()+"-passowrd-"+user.getPassword());
        return userDetails;
    }


}
