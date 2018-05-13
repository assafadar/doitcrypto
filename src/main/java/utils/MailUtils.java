package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class MailUtils {
	
	final static String FROM_MAIL_ADDRESS = "asafadar55@gmail.com";
	final static String EMAIL_ACCOUNT_PASSWORD = "Massarik11a";

	//Welocme Email
	public static void sendWelcomeEmail(String email,String name) throws Exception{
		String sub = "Welcome to the Do It Crypto Community";
		String msg = "<div style=\"color:#555555; font-size:14px;\"> <strong>Dear "+name+" ,</strong><br />"
				+ "<p>Thank you for your recent enquiry regarding cryptocurrenciy trading<br />. We are pleased to enclose our services you are intrested in. You will also find<br /> further free resources on our educational website.<br /><br /> www.readbtc.com </p><br/>"
				+ "<p>As educators, it�s our responsibillity to stay on top of the latest updates and advances -<br />" + 
				"ensuring that our resources will deliver the most recent knowledge to our community.</p><br />"
				+ "Want to reiceve a <strong>FREE</strong> VIP Trading Webinar - Cryptocurrencies to Watch in 2018?<br />" + 
				"Share the URL (link) below with your friends and family. When one of them joins<br />" + 
				"<strong>Automatic,</strong> you will get UNLIMITED FREE access to our VIP Webinars.</p><br /><br /> https://doitcrypto.com <br /><br />"
				+ "Since any friend of yours ia a friend of ours, your friend will get a <strong>FREE</strong> consultation with an<br />" + 
				"VIP Account manager. Share today, this offer is only good for a limited time.<br /><br />"
				+ "Facebook: https://www.facebook.com/read.btc <br />"
				+"Twitter: https://twitter.com/read_btc <br /><br />"
				+ "<p style=\"color:#009fca; text-align:center;\"><a href=\"https://twitter.com/read_btc\">Follow us on Twitter,<a href=\"https://www.facebook.com/read.btc\"> Facebook and Medium </p></div>";
		sendMessage(getSession(), sub, msg, email);
	} 
	// Getting the session and Authentication Obj
	private static Session getSession() {
		Session session = Session.getDefaultInstance(getProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM_MAIL_ADDRESS, EMAIL_ACCOUNT_PASSWORD);
			}
		});
		return session;
	}

	// Sending a message via gmail SMTP server.
	private static void sendMessage(Session session, String sub, String msg, String to) throws Exception {
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setContent(msg,"text/html; charset=utf-8");
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (Exception e) {
			throw new Exception("Couldn't send email");
		}
	}

	private static Properties getProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		return props;
	}
}
