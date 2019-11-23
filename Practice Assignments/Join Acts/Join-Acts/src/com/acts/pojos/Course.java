package com.acts.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	private Integer cId;
	private String courseName;

	// One to many mapped field
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Student> students;

	public Course() {
		System.out.println("In Course POJO CTOR");
	}

	public Course(Integer cId, String courseName) {
		this.cId = cId;
		this.courseName = courseName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", courseName=" + courseName + ", students=" + students + "]";
	}

	// Convenience method to add student to course
	public void addStudent(Student student) {
		if (student == null)
			students = new ArrayList<Student>();
		students.add(student);
		student.setCourse(this);
	}

}
