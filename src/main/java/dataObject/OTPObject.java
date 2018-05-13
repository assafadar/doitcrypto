package dataObject;

import java.time.LocalDateTime;
public class OTPObject {
	private String otp;
	private String phone;
	private LocalDateTime timeStamp;
	
	public OTPObject(String phone, String otp){
		this.timeStamp = LocalDateTime.now();
		this.phone = phone;
		this.otp = otp;
	}
	
	public OTPObject() {
		this.timeStamp = LocalDateTime.now();
	}
	public void setOTP(String otp) {
		this.otp = otp;
	}
	
	public String getOtp() {
		return otp;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
}
