package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDao;
import pojos.User;
import pojos.UserType;

public class RegisterUser {

	public static void main(String[] args) {

		String name; 
		String email; 
		String password; 
		String role; 
		String confirmPassword; 
		Double regAmount;
		Date regdate; 
		UserType userType;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try (Scanner sc = new Scanner(System.in) ;
				SessionFactory sf = getSf()) {

			System.out.println("Hibernate Bootstrapped!");
			System.out.println("Enter user name: ");
			name = sc.next();
			System.out.println("Enter user email: ");
			email = sc.next();
			System.out.println("Enter user password: ");
			password = sc.next();
			System.out.println("Confirm Password: ");
			confirmPassword = sc.next();
			System.out.println("Enter user role: ");
			role = sc.next();
			System.out.println("Enter reg amount: ");
			regAmount = sc.nextDouble();
			System.out.println("Enter reg date: ");
			regdate = sdf.parse(sc.next());
			System.out.println("Enter user type: ");
			userType = UserType.valueOf(sc.next());
			
			User u = new User(name, email, password, role, confirmPassword, regAmount, regdate, userType);
	
			// Create DAO instance
			UserDao dao = new UserDao();
			dao.registerUser(u);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
