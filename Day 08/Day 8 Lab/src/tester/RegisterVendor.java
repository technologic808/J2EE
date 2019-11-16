package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;
import pojos.Vendor;

public class RegisterVendor {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {

			VendorDao dao = new VendorDao();
			dao.registerVendor(
					new Vendor("Name1", "name1@gmail", "pass123", "city1", "12345", 100d, parse("0001-01-01")));
			dao.registerVendor(
					new Vendor("Name2", "name2@gmail", "pass1231", "city2", "123456", 110d, parse("0001-01-02")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
