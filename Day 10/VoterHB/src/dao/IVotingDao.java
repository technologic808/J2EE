package dao;

import java.util.List;

import pojos.Candidate;
import pojos.Voter;

public interface IVotingDao {

	// Authenticates voters
	public Voter authenticateVoter(String email, String password);
	
	// Registers voters
	public Voter registerVoter(String email, String password);
	
	// Updates voting status
	String updateVoterStatus(Voter v);
	
	// Returns list of candidates
	List<Candidate> getCandidateList();

	// Increments votes for candidate 
	String incrementVotes(Integer candidateId);

	// Returns list of party wise votes
//	List<Analysis> votesAnalysis();

	// Returns list of candidates securing max votes.
	List<Candidate> maxVotesCandidates();
	
	// Logout
	void logout();

	
}
