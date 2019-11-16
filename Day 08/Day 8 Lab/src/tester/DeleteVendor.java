package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class DeleteVendor {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {

			VendorDao dao = new VendorDao();
			System.out.println(dao.updateVendorDetails(1, "new_city", "new_123"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
