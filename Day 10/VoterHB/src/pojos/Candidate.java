package pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "acts_candidates")
public class Candidate implements Comparable<Candidate>{
	

	@Id // ID annotation is mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment id 
	private Integer id;
	private String c_name, party;
	private Integer votes;
	
	public Candidate(Integer id, String c_name, String party, Integer votes) {
		super();
		this.id = id;
		this.c_name = c_name;
		this.party = party;
		this.votes = votes;
	}
	
	
	// Mandatory default constructor
	public Candidate() {
		super();
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Integer getVotes() {
		return votes;
	}
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", c_name=" + c_name + ", party=" + party + ", votes=" + votes + "]";
	}




	@Override
	public int compareTo(Candidate o) {
		return this.votes - o.votes;
		// if this.votes > o.votes, return +ve
	}
	
}
