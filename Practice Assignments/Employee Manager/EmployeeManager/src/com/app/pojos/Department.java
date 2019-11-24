package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eval_dept")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptId;
	private Integer strength;

	@Column(unique = true)
	private String deptName;

	private String location;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees = new ArrayList<Employee>(); // Use Generic in LHS and specific in RHS

	public Department(Integer strength, String deptName, String location, List<Employee> employees) {
		this.strength = strength;
		this.deptName = deptName;
		this.location = location;
		this.employees = employees;
		System.out.println("In Department POJO constructor(P)");
	}

	public Department() {
		System.out.println("In Department POJO constructor");
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	// Convenience Methods
	public void addEmployee(Employee employee) {
		employees.add(employee);
		employee.setDepartment(this);
		this.setStrength(this.getStrength() + 1);
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", strength=" + strength + ", deptName=" + deptName + ", location="
				+ location + ", employees=" + employees + "]";
	}

}
