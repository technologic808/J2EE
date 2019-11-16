package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;

public class FireEmployee {

	public static void main(String[] args) {

		try (SessionFactory sf = getSf()) {

			System.out.println("Hibernate Bootstrapped!");
			
			DepartmentDao dao = new DepartmentDao();
			
			System.out.println(dao.fireEmp(1, 7));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
