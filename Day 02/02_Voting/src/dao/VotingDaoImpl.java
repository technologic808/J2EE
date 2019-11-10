package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojos.Candidate;
import pojos.Voter;

public class VotingDaoImpl implements IVotingDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (cn != null)
			cn.close();
		System.out.println("Voting DAO cleaned up");

	}

	public VotingDaoImpl() throws Exception {
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from voters where v_email=? and v_password=?");
		pst2 = cn.prepareStatement("select * from candidates");
		pst3 = cn.prepareStatement("UPDATE candidates SET votes = votes + 1 WHERE id = ?");
		pst4 = cn.prepareStatement("update voters set v_status = true where id = ?");

	}

	@Override
	public Voter authenticateVoter(String email, String password) throws Exception {
		// Set in parameters
		pst1.setString(1, email);
		pst1.setString(2, password);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voter(rst.getInt("id"), email, password, rst.getBoolean("v_status"));

		}
		return null;
	}

	@Override
	public ArrayList<Candidate> getCandidateList() throws Exception {
		ArrayList<Candidate> candidates = new ArrayList<>();
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next()) {
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return candidates;
	}

	@Override
	public String incVotesUpdateStatus(Integer candidateId, Integer voterId) throws Exception {
		pst3.setInt(1, candidateId);
		pst4.setInt(1, voterId);
		System.out.println(pst3.toString());
		System.out.println(pst4.toString());
		Integer rowsAffectedVoteAdded = pst3.executeUpdate();
		Integer rowsAffectedVoterStatusChanged = pst4.executeUpdate();
		System.out.println("rowsAffectedVoteAdded " + rowsAffectedVoteAdded);
		System.out.println("rowsAffectedVoterStatusChanged " + rowsAffectedVoterStatusChanged );
		if (rowsAffectedVoteAdded > 0 && rowsAffectedVoterStatusChanged > 0)
			return "Vote Successful!";
		else
			return "Vote not updated in DB";
	}

}
