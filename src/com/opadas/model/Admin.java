package com.opadas.model;

import java.io.InputStream;

public class Admin {
	private int id;
	private String name;
	private String designation;
	private String email;
	private String password;
	private String phone;
	private String status;
	private InputStream photo;

	public Admin() {

	}

	public Admin(String name, String designation, String email, String phone, String status) {

		this.name = name;
		this.designation = designation;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}
	
	

	public Admin(int id, String name, String designation, String email, String phone, String status) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}

	public Admin(String name, String designation, String email, String password, String phone, String status,
			InputStream photo) {
		
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.photo = photo;
	}

	public Admin(int id, String name, String designation, String email, String password, String phone, String status,
			InputStream photo) {
		this.id = id;
		this.name = name;
		this.designation = designation;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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
