package dao;

import static utils.HibernateUtils.getSf;

import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Candidate;
import pojos.Voter;

public class VotingDao implements IVotingDao {

	@Override
	public Voter authenticateVoter(String email, String password) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		Voter v = null;

		try {

			String jpql = "SELECT v FROM Voter  AS v WHERE v.v_email = :email AND v.v_password = :password";

			v = hs.createQuery(jpql, Voter.class).setParameter("email", email).setParameter("password", password)
					.getSingleResult();

			// Commit the transaction
			tx.commit();

			if (v != null)
				return v;
			else
				return null;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	@Override
	public Voter registerVoter(String email, String password) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		Voter v;

		try {

			// Create transient instance of voter entity
			v = new Voter(email, password, "voter", false);

//			v.setRole("voter");
//			v.setV_email(email);
//			v.setV_password(password);
//			v.setV_status(false);

			// Persist
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

	// Returns list of candidates with maximum votes
	@Override
	public List<Candidate> maxVotesCandidates() {

		// Create empty list (transient)
		List<Candidate> candidates = null;

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		try {

			String jpql = "SELECT c FROM Candidate c";

			candidates = hs.createQuery(jpql, Candidate.class).getResultList();

			Collections.sort(candidates);

			Collections.reverse(candidates);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return candidates;

	}

	@Override
	public List<Candidate> getCandidateList() {

		// Create empty list (transient)
		List<Candidate> candidates = null;

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		try {

			String jpql = "SELECT c FROM Candidate c";

			candidates = hs.createQuery(jpql, Candidate.class).getResultList();

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return candidates;

	}

	@Override
	public String updateVoterStatus(Voter v) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		try {

			// Make voter persistent
			hs.save(v);

			// Set Status
			v.setV_status(true);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return "Voter status updated";

	}

	@Override
	public String incrementVotes(Integer candidateId) {

		// Create session / get existing session
		Session hs = getSf().getCurrentSession();

		// Begin Transaction
		Transaction tx = hs.beginTransaction();

		Candidate c;

		try {

			// Get persistance instance of candidate entity
			c = hs.get(Candidate.class, candidateId);

			// increment votes
			c.setVotes(c.getVotes() + 1);

			// Commit the transaction
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return "Candidate status updated";

	}

	@Override
	public void logout() {
		// Create session / get existing session
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();

		try {
			System.out.println("in logout dao method");
			// Clear Session
			hs.clear();
			
			tx.commit();
			
		} catch (HibernateException e) {
			throw e;
		}

	}

}
