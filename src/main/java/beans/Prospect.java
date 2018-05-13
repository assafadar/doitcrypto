package beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Prospect {
	private String email;
	private String registrationDate = getDate();

	public Prospect() {
		
	}
	
	public Prospect(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	private String getDate() {
		DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String registrationDate = dateFormat.format(date);
		return registrationDate;
	}
}
