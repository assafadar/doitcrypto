package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import beans.Prospect;
import dao.SubscribeDAO;
import utils.DataValidationsUtils;
@Controller
public class SubscribeController {
	@Autowired
	private SubscribeDAO subscribeDAO;
	
	public void createSubscriber(Prospect prospect)throws Exception{
		if(DataValidationsUtils.validateEmail(prospect.getEmail())) {
			this.subscribeDAO.createSubscriber(prospect);
		}
		else {
			throw new Exception("Invalid details");
		}
	}
}
