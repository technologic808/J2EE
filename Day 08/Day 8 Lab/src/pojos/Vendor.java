package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Create Vendor POJO
//id,name,email,password,city,phone,reg amount,reg date (LocalDate)
//Add JPA annotations.
//Add mapping entry in config file.

@Entity // Mandatory Annotation for Hibernate
@Table(name = "vendors")
public class Vendor {
	
	// ID must be serializable
	private Integer id;
	private String name, email, password, city, phone;
	private Double regAmount;
	private LocalDate regDate;
	
	// Optional Parametrized constructor
	public Vendor(String name, String email, String password, String city, String phone, Double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phone = phone;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	// Default constructor is mandatory
	public Vendor() {
		
	}
	
	// For debugging purposes
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city
				+ ", phone=" + phone + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

	@Id // ID annotation is mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment id 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "vendor_name", length = 30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "vendor_email", length = 30)
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(length = 10)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "reg_amount")
	public Double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(Double regAmount) {
		this.regAmount = regAmount;
	}
	
	
	@Column(name = "reg_date")
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

}
