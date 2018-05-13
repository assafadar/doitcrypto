package managers;

import java.util.HashMap;
import java.util.Map;

import dataObject.OTPObject;
import threads.OTPCleaner;


public class OTPManager {
	private Map<String,OTPObject> otpMap = null; 
	private static OTPManager otpManager = null;
	private OTPCleaner otpCleaner;
	
	private OTPManager() {
		this.otpMap = new HashMap<String,OTPObject>();
		this.otpCleaner = new OTPCleaner();
	}
	
	public static OTPManager getInstance() {
		if(otpManager==null) {
			otpManager = new OTPManager();
		}
		return otpManager;
	}
	
	public void addOTP(String phone, OTPObject otp) throws Exception{
		otp.setPhone(phone);
		this.otpMap.put(otp.getOtp(), otp);
	}
	
	public String getPhoneByOtp(String otp)throws Exception{
		String phoneNumber = otpMap.get(otp).getPhone();
		return phoneNumber;
	}
	public OTPObject getOTPByPhone(String phone) throws Exception{
		return this.otpMap.get(phone);
	}
	public void removeOTP(String phone) throws Exception{
		this.otpMap.remove(phone);
	}
	public OTPObject getOTP(String key) {
		return this.otpMap.get(key);
	}
}
