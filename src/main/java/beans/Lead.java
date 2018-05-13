package beans;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="lead")
public class Lead extends Prospect{
	
	private int id;
	private String firstName;
	private String lastName;
	private String country;
	private String email;
	private String phone;
	private boolean activated=false;
	
	public Lead() {
		
	}
	public Lead(String firstName, String lastName, String country, String email, String phone) {
		super(email);
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.phone = phone;
	}
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="first_name", length=15)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="last_name",length=20)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="country", length=5)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="email", length=20)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="phone",length=25)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="reg_date")
	public String getRegistrationDate() {
		return super.getRegistrationDate();
	}
	
	@Column(name="activated",length=4)
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	@Override
	public String toString() {
		return "Lead [id=" + id + ", firstName=" + firstName + ", level=" + lastName + ", country=" + country + ", email="
				+ email + ", phone=" + phone + "activated= "+activated+ "]";
	}
}
