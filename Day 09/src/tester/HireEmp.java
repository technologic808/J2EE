package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import pojos.Employee;

public class HireEmp {

	public static void main(String[] args) {

		try (SessionFactory sf = getSf()) {

			System.out.println("Hibernate Bootstrapped!");
			
			DepartmentDao dao = new DepartmentDao();
			
			System.out.println(dao.hireEmp(1, new Employee("Roy", 80.0)));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
