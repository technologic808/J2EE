package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {

		try (SessionFactory sf = getSf()) {

			System.out.println("Hibernate Bootstrapped!");
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
