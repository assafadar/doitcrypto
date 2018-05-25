package controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import beans.Lead;
import dao.RegisterDAO;
import managers.OTPManager;
import otp.OTP;
import utils.DataValidationsUtils;

@Controller
public class RegisterController {
	@Autowired
	private RegisterDAO registerDAO;
	
	
	public void createRegistrtion(Lead lead) throws Exception{
				if (lead!=null) {
					lead.setPhone(
							OTP.getInternationalCodeForCountry
							(lead.getPhone(), lead.getCountry()));
					registerDAO.CreateLead(lead);
				}
				else {
					throw new Exception("lead details are empty");
				}
	}
	public void validateUser(String otp) throws Exception {
		OTPManager manager = OTPManager.getInstance();
		String phoneNumer = manager.getPhoneByOtp(otp);
		if (phoneNumer!=null) {
			this.registerDAO.validateUser(phoneNumer);
		}
		else {
			throw new Exception("Bad OTP");
		}
	}
	public List<Lead> getLeaeds() throws Exception {
		
		return this.registerDAO.getAllLeads();
	}
	public Lead getLeaed(long id) throws Exception {
		
		return this.registerDAO.getLead(id);
	}
	
}
