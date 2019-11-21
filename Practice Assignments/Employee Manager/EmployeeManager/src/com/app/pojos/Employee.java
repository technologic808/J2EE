package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eval_emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Department department;

	private String name;
	private Double salary;
	private LocalDate dob;

	// Mandatory
	public Employee() {
		System.out.println("In Employee POJO constructor");
	}

	public Employee(Department department, String name, Double salary, LocalDate dob) {
		this.department = department;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		System.out.println("In Employee POJO constructor(P)");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", department=" + department + ", name=" + name + ", salary=" + salary + ", dob="
				+ dob + "]";
	}

}
