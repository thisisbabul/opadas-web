package com.opadas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import com.opadas.dao.CommonDao;
import com.opadas.dao.impl.PatientDao;
import com.opadas.model.Appointment;
import com.opadas.model.Patient;

public class PatientService {
	private CommonDao<Patient> patientDao;

	public PatientService(ServletContext sc) {
		patientDao = new PatientDao(sc);
	}

	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patientDao.retriveUsers();
	}
	
	public boolean isValidUsernamePassword(String email, String password) {
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if (email.equals(patient.getEmail()) && password.equals(patient.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean insert(Patient patient) {
		return patientDao.insert(patient);
	}

	public boolean isUserActive(String email) {
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if (email.equals(patient.getEmail()) && patient.getStatus().equals("Active")) {
				return true;
			}
		}
		return false;
	}

	public Patient getPatient(String email) {
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if (email.equals(patient.getEmail())) {
				return patient;
			}
		}
		return null;
	}

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

	public boolean isEmailExist(String email) {
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if (email.equals(patient.getEmail())) {
				return true;
			}
		}
		return false;
	}

	
	public boolean changePassword(String email, String npass) {
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if (email.equals(patient.getEmail())) {
				patient.setPassword(npass);
				return patientDao.update(patient);
			}
		}
		return false;
	}

	public boolean update(Patient p) {
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if (p.getEmail().equals(patient.getEmail())) {
				p.setPassword(patient.getPassword());
				return patientDao.update(p);
			}
		}
		return false;
	}
	public List<Patient> getPatientByName(String name) {
		List<Patient> newPatientList = new ArrayList<Patient>();
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if(patient.getName().contains(name)){
				newPatientList.add(patient);
			}
			
		}
		return newPatientList;
	}
	public Patient getPatientById(int id) {
		List<Patient> patientList = patientDao.retriveUsers();
		for (Patient patient : patientList) {
			if(patient.getId()==id){
				return patient;
			}
			
		}
		return null;
	}

	public List<Patient> getPatientsByAppointList(List<Appointment> appointList) {
		List<Patient> newPatientList = new ArrayList<Patient>();
		List<Patient> patientList = patientDao.retriveUsers();
		for(Patient patient: patientList){
			for(Appointment appoint: appointList){
				if(patient.getId()==appoint.getId()){
					newPatientList.add(patient);
				}
			}
		}
		return newPatientList;
	}

	public List<Appointment> getAppointListByAppointList(List<Appointment> appointList) {
		List<Patient> patientList = patientDao.retriveUsers();
		for(Patient patient: patientList){
			for(Appointment appoint: appointList){
				if(patient.getId()==appoint.getPatientId()){
					appoint.setPatient(patient);
					appointList.add(appoint);
				}
			}
		}
		return appointList;
	}

	
}
