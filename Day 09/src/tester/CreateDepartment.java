package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import pojos.Department;

public class CreateDepartment {

	public static void main(String[] args) {

		try (SessionFactory sf = getSf()) {

			System.out.println("Hibernate Bootstrapped!");
			
			DepartmentDao dao = new DepartmentDao();
			
			System.out.println(dao.createNewDepartment( new Department("IT", "basement")));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
