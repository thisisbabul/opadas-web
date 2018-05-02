package com.opadas.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;

public class CommonService {
	public void sendEmail(String name, String email, String password) {

		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("opadas.bd", "opadas@bd");
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Registration Confirmation");
			message.setText("Dear " + name + ",\n\n"
					+ "Congratulations! You have been registered in our system. Please use the following username and password for signing in to our system.\n\n"
					+ "Login URL: http://localhost:8080/opadas/view/common/login.jsp\n"
					+ "Username or Email: " + email + "\n" + "Password: " + password + "\n\n"
					+ "After signing in, please check your profile information. If you find any mistake, please contact you coordinator to update those information.\n"
					+ "We suggest that you keep this email safe, so that you can have you password in case you forget it.\n\n"
					+ "With regards,\n" + "Babul Miah\n" + "OPADAS, Dhaka-1205");
			// send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	public String extractFileName(Part filePart) {
		String contentDis = filePart.getHeader("content-disposition");
		String[] items = contentDis.split(";");
		for(String s: items){
			if(s.trim().startsWith("filename")){
				return s.substring(s.indexOf("=")+2, s.length()-1);
			}
		}
		return null;
	}
	
	public void sendEmail(String name, String email, int prescriptionid) {

		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("opadas.bd", "opadas@bd");
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Registration Confirmation");
			message.setText("Dear " + name + ",\n\n"
					+ "Congratulations! You have prescriped by your corresponding doctor\n\n"
					+ "Login URL: http://localhost:8080/opadas/view/common/login.jsp\n"
					+ "Username or Email: " + email + "\n" + "Prescription Id: " + prescriptionid + "\n\n"
					+ "With regards,\n" + "Babul Miah\n" + "OPADAS, Dhaka-1205");
			// send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
}
