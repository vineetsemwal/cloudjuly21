package com.example.securitydemo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class AddAdminRequest {

    @NotBlank
    @Length(max=20)
    private String username;

    @NotBlank
    @Length(max=10)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
