package dao;

import static utils.HibernateUtils.getSf;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.Employee;

public class DepartmentDao implements IDepartmentDao {

	@Override
	public String createNewDepartment(Department d) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		try {

			// Persist vendor
			hs.save(d);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return "created new department";
	}

	@Override
	public String hireEmp(int deptId, Employee e) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		// Department d
		Department d;

		try {

			// Get persistent instance of department entity
			d = hs.get(Department.class, deptId);

			// Call convenience method to add employee to department
			d.addEmployee(e);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			throw exc;
		}

		return d.toString() + e.toString();
	}

	@Override
	public List<Employee> listEmps(String deptName) {

		// Create empty list (transient)
		List<Employee> employees = null;

		// Create empty department object
		Department department = null;

		// Get Hibernate Session object instance
		Session hs = getSf().getCurrentSession();

		// Create transaction object instance
		Transaction tx = hs.beginTransaction();

		try {

			// Get department entity from database
			String jpql = "SELECT d FROM Department AS d JOIN FETCH d.emps WHERE d.name = :d ";
			department = hs.createQuery(jpql, Department.class).setParameter("d", deptName).getSingleResult();

			// Try to access the employee list in the department
			employees = department.getEmps();

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return employees;
	}

	@Override
	public String fireEmp(Integer deptId, Integer empId) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		// Department d
		Department d;

		// Employee e
		Employee e;

		try {

			// Get persistent instance of department entity
			d = hs.get(Department.class, deptId);

			// Get persistent instance of employee
			e = hs.get(Employee.class, empId);
			System.out.println("depat and emp "+d+"\t"+e);
			// Call convenience method to delete employee to department
			d.removeEmployee(e);

			// remove employee
			//if (e != null)
			//	hs.delete(e);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			throw exc;
		}

		return d.toString() + e.toString();
	}

}
