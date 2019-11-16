package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class GetSelectedVendors {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {

			VendorDao dao = new VendorDao();
			System.out.println(dao.getSelectedVendors("city2", LocalDate.parse("0001-01-02")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
