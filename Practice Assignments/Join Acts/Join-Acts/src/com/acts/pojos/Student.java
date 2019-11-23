package com.acts.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	private Integer sId;
	private String studentName;
	private String address;
	private LocalDate dob;
	private Double cgpa;

	// ManyToOne mapped element
	@ManyToOne
	private Course course;

	public Student() {
		System.out.println("In Student POJO CTOR");
		this.studentName = "Enter Name";
	}

	public Student(String name, String address, LocalDate dob, Double cgpa) {
		this.studentName = name;
		this.address = address;
		this.dob = dob;
		this.cgpa = cgpa;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getName() {
		return studentName;
	}

	public void setName(String name) {
		this.studentName = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", studentName=" + studentName + ", address=" + address + ", dob=" + dob
				+ ", cgpa=" + cgpa + ", course=" + course + "]";
	}

}
