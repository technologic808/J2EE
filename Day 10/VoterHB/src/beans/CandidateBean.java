package beans;

import java.util.List;

import dao.VotingDao;
import pojos.Candidate;

public class CandidateBean {

	// Declares members to store the conversational state of the client
	private Integer cId;
	private VotingDao dao;

	// Default Constructor
	public CandidateBean() throws Exception {
		System.out.println("In Candidate Bean's constructor");
		dao = new VotingDao();
	}

	// Sets candidate id
	public void setcId(Integer cId) {
		this.cId = cId;
	}

	// Business Logic Methods

	// 1. Gets List of Candidates
	public List<Candidate> getCandidateList() throws Exception {
		List<Candidate> list = dao.getCandidateList(); 
		System.out.println("List of Candidates " + list);
		return list;
	}

	// 2. Updates candidate status on voting
	public String updateVotes() throws Exception {
		System.out.println("In updateVotes method in Candidate Bean CID" + cId);
		return dao.incrementVotes(cId);
	}

	// 3. Gets votes statistics for admin

	// 4. Gets the candidate with maximum votes

}
