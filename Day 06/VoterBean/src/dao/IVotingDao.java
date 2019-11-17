package dao;

import java.util.List;

import pojos.Candidate;
import pojos.Voter;

public interface IVotingDao {

	// Authenticates voters
	public Voter authenticateVoter(String email, String password) throws Exception;
	
	// Updates voting status
	String updateVoterStatus(Voter v) throws Exception;
	
	// Returns list of candidates
	List<Candidate> getCandidateList() throws Exception;

	// Increments votes for candidate 
	String incrementVotes(Integer candidateId) throws Exception;

	// Returns list of party wise votes
//	List<Analysis> votesAnalysis();

	// Returns list of candidates securing max votes.
	List<Candidate> maxVotesCandidates() throws Exception;

	
}
