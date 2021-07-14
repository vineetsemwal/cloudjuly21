package com.example.customermsrest.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CreateCustomerRequest {

    @Length(max = 20, min =1)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
