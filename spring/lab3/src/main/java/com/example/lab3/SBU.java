package com.example.lab3;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class SBU {

    @Value("${sbu.code}")
    private int sbuCode;
    @Value("${sbu.name}")
    private String sbuName;
    private List<Employee> employees;

    public int getSbuCode() {
        return sbuCode;
    }

    public void setSbuCode(int sbuCode) {
        this.sbuCode = sbuCode;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
