package com.example.securitydemo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class AddCustomerRequest {

    @NotBlank
    @Length(max=20)
    private String username;

    @NotBlank
    @Length(max=10)
    private String password;


    private double amount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
