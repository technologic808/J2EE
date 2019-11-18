package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "acts_voters")
public class Voter {
	
	@Id // ID annotation is mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment id 
	private Integer id;
	
	@Column(unique = true)
	private String v_email;
	
	
	private String v_password, role;
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

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", v_email=" + v_email + ", role=" + role + ", v_status=" + v_status + "]";
	}
	public Voter(String v_email, String v_password, String role, Boolean v_status) {
		super();
		this.v_email = v_email;
		this.v_password = v_password;
		this.role = role;
		this.v_status = v_status;
	}
	
	// Mandatory Default Constructor
	public Voter() {
		super();
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}
	public void setV_password(String v_password) {
		this.v_password = v_password;
	}
	
}
