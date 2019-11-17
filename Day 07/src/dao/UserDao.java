package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.User;

public class UserDao implements IUserDao {

	@Override
	public String registerUser(User u) {
		// TODO Auto-generated method stub
		Session hs = getSf().openSession();
		
		//begin tx
		Transaction tx = hs.beginTransaction();
		
		try {
			hs.save(u);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!= null)
				tx.rollback();
			// rethrow exc to the caller
			throw e;
		}
		finally {
			// close session == returns pooled out DB...
			hs.close();
		}
		
		return null;
	}

}
