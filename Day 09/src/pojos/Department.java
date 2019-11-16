package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="dac_depts")
public class Department extends AbstractEntity {
	@Column(length = 20, unique = true)
	private String name;
	
	@Column(length = 20)
	private String location;
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval =true)
	private List<Employee> emps = new ArrayList<>(); // Use Generic in LHS and specific in RHS
	
	public Department() {
		super();
	}
	
	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
	// add helper method to remove and add employee

	public void addEmployee(Employee e) {
		emps.add(e); // dept --> emp
		System.out.println(e.getDept());
		e.setDept(this);
	}
	public void removeEmployee(Employee e) {
		emps.remove(e); 
		e.setDept(null);
	}
	
}
