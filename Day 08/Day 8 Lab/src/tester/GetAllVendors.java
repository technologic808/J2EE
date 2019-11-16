package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class GetAllVendors {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {

			VendorDao dao = new VendorDao();
			System.out.println(dao.getAllVendors());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
