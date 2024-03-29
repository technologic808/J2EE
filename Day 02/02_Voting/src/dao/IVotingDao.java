package dao;

import java.util.HashMap;
import java.util.List;

import pojos.Candidate;
import pojos.Voter;

public interface IVotingDao {
	public Voter authenticateVoter(String email,String password) throws Exception;
	public List<Candidate> getCandidateList() throws Exception;
	public String incVotesUpdateStatus(Integer candidateId,Integer voterId) throws Exception;
	public HashMap<Integer, Candidate> topCandidates(Integer topNo) throws Exception;
	public HashMap<String, Integer> votesByParty() throws Exception;
}
