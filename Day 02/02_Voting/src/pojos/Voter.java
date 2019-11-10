package pojos;

public class Voter {
	private Integer id;
	private String v_email, v_password;
	private Boolean v_status;
	public Boolean getV_status() {
		return v_status;
	}
	public void setV_status(Boolean v_status) {
		this.v_status = v_status;
	}
	public Integer getId() {
		return id;
	}
	public String getV_email() {
		return v_email;
	}
	public String getV_password() {
		return v_password;
	}
	public Voter(Integer id, String v_email, String v_password, Boolean v_status) {
		super();
		this.id = id;
		this.v_email = v_email;
		this.v_password = v_password;
		this.v_status = v_status;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", v_email=" + v_email + ", v_status=" + v_status + "]";
	}
	
}
