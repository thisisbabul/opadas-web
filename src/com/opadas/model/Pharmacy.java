package com.opadas.model;

import java.io.InputStream;

public class Pharmacy {
	private int id;
	private String pharmacyName;
	private String ownerOfPharmacy;
	private String address;
	private String email;
	private String password;
	private String phone;
	private String status;
	private InputStream photo;

	

	public Pharmacy() {
		
	}

	public Pharmacy(String pharmacyName, String ownerOfPharmacy, String address, String email, String password,
			String phone, String status, InputStream photo) {
		super();
		this.pharmacyName = pharmacyName;
		this.ownerOfPharmacy = ownerOfPharmacy;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.photo = photo;
	}

	public Pharmacy(int id, String pharmacyName, String ownerOfPharmacy, String address, String email, String password,
			String phone, String status) {
		super();
		this.id = id;
		this.pharmacyName = pharmacyName;
		this.ownerOfPharmacy = ownerOfPharmacy;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
	}

	public Pharmacy(int id, String pharmacyName, String ownerOfPharmacy, String address, String email, String password,
			String phone, String status, InputStream photo) {
		super();
		this.id = id;
		this.pharmacyName = pharmacyName;
		this.ownerOfPharmacy = ownerOfPharmacy;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getOwnerOfPharmacy() {
		return ownerOfPharmacy;
	}

	public void setOwnerOfPharmacy(String ownerOfPharmacy) {
		this.ownerOfPharmacy = ownerOfPharmacy;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InputStream getPhoto() {
		return photo;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}

}
