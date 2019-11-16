package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Vendor;

public interface IVendorDao {

//	1. String registerVendor(Vendor v)
	public String registerVendor(Vendor v);
	
//	2. Vendor getDetails(int id);
	public Vendor getDetails(Integer id);
	
//	3. List all vendor details
//		List<Vendor> getAllVendors()
	List<Vendor> getAllVendors();	
	
//	4. List all vendors from specified city after specific reg date
//		List<Vendor> getSelectedVendors(String city,LocalDate dt)
	List<Vendor> getSelectedVendors(String city, LocalDate date);
	
//	5. String updateVendorDetails(int vid,String newCity,String newPhone)
	String updateVendorDetails(Integer vendor_id, String newCity, String newPhone);
	
//	6. Unsubscribe vendor
//		String deleteVendorDetails(int vid)
	String deleteVendorDetails(Integer vendor_id);
}
