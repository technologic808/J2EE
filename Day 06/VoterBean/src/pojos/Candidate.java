package pojos;

public class Candidate {
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
	
}
