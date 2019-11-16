package pojos;

import javax.persistence.*;

@Entity
@Table(name="dac_emps")
public class Employee extends AbstractEntity {
	
	@Column(length = 20, unique = true)
	private String name;

	private Double salary;
	
	@ManyToOne
	private Department dept;

	public Employee(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	// Mandatory Default Constructor
	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
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

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if(getId().equals(emp.getId()))
				return true;
			else return false;
		}
		return false;
	}

	
	
}
