package com.opadas.service;

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
import com.opadas.dao.impl.AdminDao;
import com.opadas.model.Admin;

public class AdminService {
	private CommonDao<Admin> adminDao;

	public AdminService(ServletContext sc) {
		adminDao = new AdminDao(sc);
	}

	public boolean isValidUsernamePassword(String email, String password) {
		List<Admin> adminList = adminDao.retriveUsers();
		for (Admin admin : adminList) {
			if (email.equals(admin.getEmail()) && password.equals(admin.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean insert(Admin admin) {
		return adminDao.insert(admin);
	}

	public boolean isUserActive(String email) {
		List<Admin> adminList = adminDao.retriveUsers();
		for (Admin admin : adminList) {
			if (email.equals(admin.getEmail()) && admin.getStatus().equals("Active")) {
				return true;
			}
		}
		return false;
	}

	public Admin getAdmin(String email) {
		List<Admin> adminList = adminDao.retriveUsers();
		for (Admin admin : adminList) {
			if (email.equals(admin.getEmail())) {
				return admin;
			}
		}
		return null;
	}

	public boolean isEmailExist(String email) {
		List<Admin> adminList = adminDao.retriveUsers();
		for (Admin admin : adminList) {
			if (email.equals(admin.getEmail())) {
				return true;
			}
		}
		return false;
	}

	
	public boolean changePassword(String email, String npass) {
		List<Admin> adminList = adminDao.retriveUsers();
		for (Admin admin : adminList) {
			if (email.equals(admin.getEmail())) {
				admin.setPassword(npass);
				return adminDao.update(admin);
			}
		}
		return false;
	}

	public boolean update(Admin ad) {
		List<Admin> adminList = adminDao.retriveUsers();
		for (Admin admin : adminList) {
			if (ad.getEmail().equals(admin.getEmail())) {
				ad.setPassword(admin.getPassword());
				return adminDao.update(ad);
			}
		}
		return false;
	}

}
