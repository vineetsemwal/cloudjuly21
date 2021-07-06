package com.example.onetoonebi.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "addresses")
@Entity
public class Address {

    @GeneratedValue
    @Id
    private Long id;

    private String city;

    private String houseInfo;

    @OneToOne(mappedBy="address")
    private Employee employee;

    public Address() {
    }

    public Address(String city, String housinfo, Employee employee){
        this.city=city;
        this.houseInfo=housinfo;
        this.employee=employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
