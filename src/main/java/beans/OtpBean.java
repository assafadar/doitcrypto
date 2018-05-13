package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OtpBean {
	private String otp;
	
	public OtpBean() {
		
	}
	

	public OtpBean(String otp) {
		super();
		this.otp = otp;
	}


	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}


	
	
}
