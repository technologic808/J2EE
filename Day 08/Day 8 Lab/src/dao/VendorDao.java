package dao;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Vendor;

public class VendorDao implements IVendorDao {

	@Override
	public String registerVendor(Vendor v) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		try {

			// Persist vendor
			hs.save(v);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return null;
	}

	@Override
	public Vendor getDetails(Integer id) {

		// Create pojo instance (transient state)
		Vendor v = null;

		// Get HSession object instance
		Session hs = getSf().getCurrentSession();

		// Create transaction object instance
		Transaction tx = hs.beginTransaction();

		try {

			// Get a persistant instance of vendor
			v = hs.get(Vendor.class, id);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return v;
	}

	@Override
	public List<Vendor> getAllVendors() {

		// Create empty list (transient)
		List<Vendor> vendors = null;

		// Get Hibernate Session object instance
		Session hs = getSf().getCurrentSession();

		// Create transaction object instance
		Transaction tx = hs.beginTransaction();

		try {

			String jpql = "SELECT v FROM Vendor AS v";
			vendors = hs.createQuery(jpql, Vendor.class).getResultList();

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return vendors;
	}

	@Override
	public List<Vendor> getSelectedVendors(String city, LocalDate date) {

		// Create empty list (transient)
		List<Vendor> vendors = null;

		// Get Hibernate Session object instance
		Session hs = getSf().getCurrentSession();

		// Create transaction object instance
		Transaction tx = hs.beginTransaction();

		try {

			String jpql = "SELECT v FROM Vendor AS v WHERE v.city = :c AND v.regDate = :d";
			vendors = hs.createQuery(jpql, Vendor.class).setParameter("c", city).setParameter("d", date)
					.getResultList();

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return vendors;
	}

	@Override
	public String updateVendorDetails(Integer vendor_id, String newCity, String newPhone) {

		// Get Hibernate Session object instance
		Session hs = getSf().getCurrentSession();

		// Create transaction object instance
		Transaction tx = hs.beginTransaction();

		try {

			String jpql = "SELECT v FROM Vendor AS v WHERE v.id = :id";
			Vendor v = hs.createQuery(jpql, Vendor.class).setParameter("id", vendor_id).getSingleResult();
			
			v.setCity(newCity);
			v.setPhone(newPhone);
		
			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return "updated";
	}

	@Override
	public String deleteVendorDetails(Integer vendor_id) {

		// Get Hibernate Session object instance
		Session hs = getSf().getCurrentSession();

		// Create transaction object instance
		Transaction tx = hs.beginTransaction();
		
		Vendor v = null;

		try {

			String jpql = "SELECT v FROM Vendor AS v WHERE v.id = :id";
			v = hs.createQuery(jpql, Vendor.class).setParameter("id", vendor_id).getSingleResult();

			hs.delete(v);
		
			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		
		return v.toString();
	}

}
