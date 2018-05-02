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
import com.opadas.dao.impl.DoctorDao;
import com.opadas.model.Doctor;

public class DoctorService {
	private CommonDao<Doctor> doctorDao;

	public DoctorService(ServletContext sc) {
		doctorDao = new DoctorDao(sc);
	}

	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return doctorDao.retriveUsers();
	}
	
	public boolean isValidUsernamePassword(String email, String password) {
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if (email.equals(doctor.getEmail()) && password.equals(doctor.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean insert(Doctor doctor) {
		return doctorDao.insert(doctor);
	}

	public boolean isUserActive(String email) {
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if (email.equals(doctor.getEmail()) && doctor.getStatus().equals("Active")) {
				return true;
			}
		}
		return false;
	}

	public Doctor getDoctor(String email) {
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if (email.equals(doctor.getEmail())) {
				return doctor;
			}
		}
		return null;
	}


	public boolean isEmailExist(String email) {
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if (email.equals(doctor.getEmail())) {
				return true;
			}
		}
		return false;
	}

	
	public boolean changePassword(String email, String npass) {
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if (email.equals(doctor.getEmail())) {
				doctor.setPassword(npass);
				return doctorDao.update(doctor);
			}
		}
		return false;
	}

	public boolean update(Doctor d) {
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if (d.getEmail().equals(doctor.getEmail())) {
				d.setPassword(doctor.getPassword());
				return doctorDao.update(d);
			}
		}
		return false;
	}
	public List<Doctor> getDoctorsByName(String name) {
		List<Doctor> newDoctorList = new ArrayList<Doctor>();
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if(doctor.getName().contains(name)){
				newDoctorList.add(doctor);
			}
			
		}
		return newDoctorList;
	}
	public Doctor getDoctorsById(int id) {
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if(doctor.getId()==id){
				return doctor;
			}
			
		}
		return null;
	}

	public List<Doctor> getDoctorsByExpertise(String expertise) {
		List<Doctor> newDoctorList = new ArrayList<Doctor>();
		List<Doctor> doctorList = doctorDao.retriveUsers();
		for (Doctor doctor : doctorList) {
			if(doctor.getExpertise().contains(expertise)){
				newDoctorList.add(doctor);
			}
			
		}
		return newDoctorList;
	}
}
