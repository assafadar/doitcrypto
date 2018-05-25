package otp;
import java.util.Random;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class OTP {
	public static final String ACC_SID="AC26e1dcfa511159225bb926b91fabb0d9";
	public static final String AUTH_TOKEN="1630e19e9c6a48e5da9a39a3aacfbbbb";
	
	public static String sendOTP(String phoneNumber){
	
		Twilio.init(ACC_SID, AUTH_TOKEN);
		String otp = generateOTP();
		Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber("+16149571236"), "OTP: "+otp+", DoItCrypto!").create();
		return otp;
	}

	private static String generateOTP() {
		Random rnd = new Random();
		String otp="";
		int [] otpNums = new int[4];
		for (int i = 0; i < otpNums.length; i++) {
			otpNums[i] = rnd.nextInt(10);
			otp+=Integer.toString(otpNums[i]);
		}
		return otp;
	}
	
	public static String getInternationalCodeForCountry(String originalPhoneNumber, String countryISO) throws Exception{
		Twilio.init(ACC_SID, AUTH_TOKEN);
		com.twilio.rest.lookups.v1.PhoneNumber phoneNumber = 
				com.twilio.rest.lookups.v1.PhoneNumber.fetcher(new PhoneNumber(originalPhoneNumber))
				.setCountryCode(countryISO).fetch();
		return phoneNumber.getPhoneNumber().toString();
	}

}
