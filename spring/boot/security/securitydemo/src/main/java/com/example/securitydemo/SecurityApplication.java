package com.example.securitydemo;

import com.example.securitydemo.dto.AddAdminRequest;
import com.example.securitydemo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecurityApplication {

    @Autowired
    private IAdminService service;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SecurityApplication.class, args);
        SecurityApplication app = context.getBean(SecurityApplication.class);
        app.addAdmin();
    }

    public void addAdmin() {
        AddAdminRequest request=new AddAdminRequest();
        request.setUsername("hemanth");
        request.setPassword("1234");
        service.add(request);
    }

}
