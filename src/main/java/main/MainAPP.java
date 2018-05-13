package main;

import beans.OtpBean;
import dao.RegisterDAO;

public class MainAPP {

	public static void main(String[] args) {
		RegisterDAO dao = new RegisterDAO();
		try {
			System.out.println(dao.getLead(4).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
