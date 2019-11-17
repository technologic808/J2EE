package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import pojos.Voter;

public class VotingDao implements IVotingDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5, pst6;

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (pst5 != null)
			pst5.close();
		if (pst6 != null)
			pst6.close();
		if (cn != null)
			cn.close();
		System.out.println("Voting DAO cleaned up");

	}



	public VotingDao() throws Exception {
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from voters where v_email=? and v_password=?");
		pst2 = cn.prepareStatement("select * from candidates");
		pst3 = cn.prepareStatement("UPDATE candidates SET votes = votes + 1 WHERE id = ?");
		pst4 = cn.prepareStatement("update voters set v_status = true where id = ?");
		pst5 = cn.prepareStatement("select * from candidates order by votes desc limit ?");
		pst6 = cn.prepareStatement("select party, votes from candidates"); 

	}
	

	@Override
	public Voter authenticateVoter(String email, String password) throws Exception {
		// Sets in parameters
		pst1.setString(1, email);
		pst1.setString(2, password);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voter(rst.getInt("id"), email, password, rst.getString("role"), rst.getBoolean("v_status"));

		}
		return null;
	}
	
	// Returns list of candidates with maximum votes
	@Override
	public List<Candidate> maxVotesCandidates() throws Exception {
		
		// Create empty list
		List<Candidate> candidates = new ArrayList<>();
		this.pst5.setInt(1, 1); // Set parameter to the number of top candidates to return
		
		// Generates list by executing prepared statements and accessing the resultset
		try (ResultSet rst = pst5.executeQuery()) {
			while (rst.next()) {
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		
		// Prints list for debugging
		System.out.println(candidates);
		
		// Returns list
		return candidates;
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
	public String updateVoterStatus(Voter v) throws Exception {
		pst4.setInt(1, v.getId());
		System.out.println(pst4.toString());
		Integer rowsAffectedVoterStatusChanged = pst4.executeUpdate();
		System.out.println("rowsAffectedVoterStatusChanged " + rowsAffectedVoterStatusChanged );
		if (rowsAffectedVoterStatusChanged > 0)
			return "Voter status updated";
		else
			return "Voter status not updated";
	}



	@Override
	public String incrementVotes(Integer candidateId) throws Exception {
		pst3.setInt(1, candidateId);
		System.out.println(pst3.toString());
		Integer rowsAffectedVoteAdded = pst3.executeUpdate();
		System.out.println("rowsAffectedVoteAdded " + rowsAffectedVoteAdded);
		if (rowsAffectedVoteAdded > 0)
			return "Candidate status updated";
		else
			return "Candidate status not updated";
	}

	

}
