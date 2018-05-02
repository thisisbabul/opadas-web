package com.opadas.service;

import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.dao.impl.PharmacyDao;
import com.opadas.model.Pharmacy;

public class PharmacyService {
	private CommonDao<Pharmacy> pharmacyDao;

	public PharmacyService(ServletContext sc) {
		pharmacyDao = new PharmacyDao(sc);
	}

	public boolean isValidUsernamePassword(String email, String password) {
		List<Pharmacy> pharmacyList = pharmacyDao.retriveUsers();
		for (Pharmacy pharmacy : pharmacyList) {
			if (email.equals(pharmacy.getEmail()) && password.equals(pharmacy.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean insert(Pharmacy pharmacy) {
		return pharmacyDao.insert(pharmacy);
	}

	public List<Pharmacy> getPharmacies(){
		return pharmacyDao.retriveUsers();
	}
	public boolean isUserActive(String email) {
		List<Pharmacy> pharmacyList = pharmacyDao.retriveUsers();
		for (Pharmacy pharmacy : pharmacyList) {
			if (email.equals(pharmacy.getEmail()) && pharmacy.getStatus().equals("Active")) {
				return true;
			}
		}
		return false;
	}

	public Pharmacy getPharmacy(String email) {
		List<Pharmacy> pharmacyList = pharmacyDao.retriveUsers();
		for (Pharmacy pharmacy : pharmacyList) {
			if (email.equals(pharmacy.getEmail())) {
				return pharmacy;
			}
		}
		return null;
	}

	public boolean isEmailExist(String email) {
		List<Pharmacy> pharmacyList = pharmacyDao.retriveUsers();
		for (Pharmacy pharmacy : pharmacyList) {
			if (email.equals(pharmacy.getEmail())) {
				return true;
			}
		}
		return false;
	}

	
	public boolean changePassword(String email, String npass) {
		List<Pharmacy> pharmacyList = pharmacyDao.retriveUsers();
		for (Pharmacy pharmacy : pharmacyList) {
			if (email.equals(pharmacy.getEmail())) {
				pharmacy.setPassword(npass);
				return pharmacyDao.update(pharmacy);
			}
		}
		return false;
	}

	public boolean update(Pharmacy ad) {
		List<Pharmacy> pharmacyList = pharmacyDao.retriveUsers();
		for (Pharmacy pharmacy : pharmacyList) {
			if (ad.getEmail().equals(pharmacy.getEmail())) {
				ad.setPassword(pharmacy.getPassword());
				return pharmacyDao.update(ad);
			}
		}
		return false;
	}

}
