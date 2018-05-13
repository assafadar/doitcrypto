package api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import beans.OtpBean;
import controllers.RegisterController;
@RestController

public class OtpAPI {
	@Autowired
	private RegisterController registerController;
	
	@RequestMapping(value="/leads/otp",method=RequestMethod.POST, consumes="application/json")
	public void checkOtp(@RequestBody OtpBean otp) throws Exception{
		this.registerController.validateUser(otp.getOtp());
	}
}
