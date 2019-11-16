package dao;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface IDepartmentDao {
	
// 	1. Create a new department
	String createNewDepartment(Department d);
	
//	2. Hire Emp in a dept.
	String hireEmp(int deptId,Employee e);
	
//	3. Display employees from a specific dept.
	List<Employee> listEmps(String deptName);
	
//	4. Fire employee from a dept
	String fireEmp(Integer deptId,Integer empId);
}
