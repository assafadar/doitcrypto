//package api;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import javax.servlet.http.HttpServletResponse;
//
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import beans.Lead;
//import controllers.RegisterController;
//import dataObject.OTPObject;
//import managers.CountryManager;
//import managers.OTPManager;
//import otp.OTP;
//import utils.MailUtils;
//@RestController
//@RequestMapping(value="/instapge", consumes="application/json",produces="application/json")
//public class InstaPage{
//	@Autowired
//	private RegisterController registerController;
//	
//	@PostMapping
//	public void createLead(Lead lead, HttpServletResponse res) {	
//		
//			try {
//			this.registerController.createRegistrtion(lead);
//			//OTP verification
//			try {
//				sendOTP(lead.getPhone());
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			//Welcome email
//			MailUtils.sendWelcomeEmail(lead.getEmail(), lead.getFullName());
//			//Send to platform
//			//integrateExecutiveCrypto(lead);
//			//res.sendRedirect("http://executivecrypto.com/back.php/affiliate/externalSorce/api?key=pkOlcKLugj&method=createLead&first_name="+lead.getFullName()+"&last_name="+lead.getFullName()+"&email_address="+lead.getEmail()+"&phone="+lead.getPhone()+"&countryISO="+getISO(lead.getCountry())+"&is_lead_only=0&campaign_id="+getKey(lead.getCountry())+"&campaign_keyword=facebook&custom_refer=fsfs&currency=BTC");
//			//OTP Verification page.
//			res.sendRedirect("otp.html");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	private void integrateExecutiveCrypto(Lead lead) throws IOException, URISyntaxException {	
//		HttpClient client = HttpClientBuilder.create().build();
//		URIBuilder builder = new URIBuilder();
//		builder.setScheme("http").setHost("www.executivecrypto.com").setPath("/back.php/affiliate/externalSorce/api")
//		    .setParameter("key", "pkOlcKLugj")
//		    .setParameter("method", "createLead")
//		    .setParameter("first_name", lead.getFullName())
//		    .setParameter("last_name", lead.getFullName())
//		    .setParameter("email_address", lead.getEmail())
//		    .setParameter("phone", lead.getPhone())
//		    .setParameter("countryISO", getISO(lead.getCountry()))
//		    .setParameter("is_lead_only", "0")
//		    .setParameter("campaign_id", getKey(lead.getCountry()))
//		    .setParameter("campaign_keyword", "martin")
//		    .setParameter("currency", "BTC");
//		URI uri = builder.build();
//		HttpGet httpget = new HttpGet(uri);
//		System.out.println(httpget.getURI());
//		client.execute(httpget);
//	}
//
//	private String getKey(String country) {
//		if(country.equals("United States")) {
//			return null;
//		}
//		if(isGCC(country)) {
//			return "242";
//		}
//		else {
//			return "248";
//		}
//		
//	}
//	private boolean isGCC(String country) {
//		if(country.equals("Bahrain") || country.equals("Kuwait") || country.equals("Oman") || country.equals("Qatar") || country.equals("Saudi Arabia") || country.equals("United Arab Emirates"))
//		{
//			return true;
//		}
//			return false;
//	}
//
//	private String getISO(String country){
//		CountryManager countriesManager = CountryManager.getInstance();
//		return countriesManager.getIsoCode(country);
//	}
//
//	private void sendOTP(String phone) throws Exception{
//		String newOtp = OTP.sendOTP(phone);
//		OTPObject otp = new OTPObject();
//		otp.setOTP(newOtp);
//		otp.setPhone(phone);
//		OTPManager otpMap = OTPManager.getInstance();
//		otpMap.addOTP(otp.getOtp(), otp);
//	}
//}
