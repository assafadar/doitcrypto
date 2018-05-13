package api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import beans.Lead;
import controllers.RegisterController;
import dataObject.OTPObject;
import managers.OTPManager;
import otp.OTP;
//import utils.MailUtils;
@RestController
public class LeadAPI {
	
	
	@Autowired
	private RegisterController registerController;
	
	@RequestMapping(value="/leads",method=RequestMethod.POST, consumes = "application/json")
	public void register(@RequestBody Lead lead) throws Exception {
		System.out.println("In Controller");
		this.registerController.createRegistrtion(lead);
		sendOTP(lead.getPhone());
	//	MailUtils.sendWelcomeEmail(lead.getEmail(), lead.getFullName());
	}
	private void sendOTP(String phone) throws Exception {
		String otp = OTP.sendOTP(phone);
		OTPManager otpManager = OTPManager.getInstance();
		OTPObject otpObject = new OTPObject(phone,otp);
		otpManager.addOTP(phone, otpObject);
	}
	@RequestMapping(value="/leads", method=RequestMethod.GET, produces = "application/json" )
	public List<Lead> getLeads() throws Exception {
		return this.registerController.getLeaeds();
	}
	@RequestMapping(value="/leads/{id}", method=RequestMethod.GET, produces = "application/json")
	public Lead getLead(@PathVariable long id) throws Exception {
		return this.registerController.getLeaed(id);
	}
}
