package com.example.securitydemo.util;

import com.example.securitydemo.dto.AdminDetails;
import com.example.securitydemo.entities.Admin;
import com.example.securitydemo.entities.AppUser;
import org.springframework.stereotype.Component;

@Component
public class AdminUtil {

    public AdminDetails toDetails(Admin admin){
        AppUser user=admin.getUser();
        AdminDetails desired=new AdminDetails();
        desired.setId(admin.getId());
        desired.setUsername(user.getUsername());
        desired.setPassword(user.getPassword());
        return desired;
    }

}
