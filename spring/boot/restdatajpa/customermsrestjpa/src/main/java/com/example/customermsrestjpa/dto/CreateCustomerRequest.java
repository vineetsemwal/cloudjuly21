package com.example.customermsrestjpa.dto;

import org.hibernate.validator.constraints.Length;

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
