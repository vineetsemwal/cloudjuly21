package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperimentController {

    @GetMapping("/p/hello")
    public String publicHello(){
        return "public hello";
    }

    @GetMapping("/c/hello")
    public String customerHello(){
        return "customer hello";
    }

    @GetMapping("/a/hello")
    public String adminHello(){
        return "admin hello";
    }

}
