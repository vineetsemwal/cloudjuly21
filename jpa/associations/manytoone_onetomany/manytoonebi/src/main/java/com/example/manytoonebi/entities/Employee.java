package com.example.manytoonebi.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "employees")
@Entity
public class Employee {

	@GeneratedValue
	@Id
	private Long id;

	private String name;

	@ManyToOne
	private Department dept;

	public Employee() {
	}

	public Employee(String name, Department dept) {
		this.name = name;
		this.dept = dept;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
