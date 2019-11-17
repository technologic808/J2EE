package pojos;

import java.util.Date;

// annotations from JPA specs
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity // Mandatory Annotation for Hibernate
@Table(name = "dac_users")
public class User{

	// ID -- Must be serializable
	private Integer userId;
	private String name, email, password, role, confirmPassword;
	private Double regAmount;
	private Date regdate;
	private UserType userType;
	
	private byte[] image;
	
	// Default constructor is mandatory
	public User() {
		super();
		System.out.println("Default Constructor for User");
	}

	// Parametrized constructor is optional
	public User(String name, String email, String password, String role, String confirmPassword, Double regAmount,
			Date regdate, UserType userType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.regdate = regdate;
		this.userType = userType;
	}

	// Must generate ALL getters and setters
	
	@Id // Mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	// Only for Debugging
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount + ", regdate=" + regdate
				+ ", userType=" + userType + "]";
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 30, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(name = "reg_amount")
	public Double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(Double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_type", length = 20)
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Lob // column type = blob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
