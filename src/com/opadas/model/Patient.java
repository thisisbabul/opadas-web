package com.opadas.model;

import java.io.InputStream;

public class Patient {
	private int id;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String password;
	private String status;
	private InputStream photo;

	public Patient() {

	}

	public Patient(String name, String address, String mobile, String email, String password, String status,
			InputStream photo) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.status = status;
		this.photo = photo;
	}

	public Patient(String name, String address, String mobile, String email, String password, String status) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public Patient(int id, String name, String address, String mobile, String email, String password, String status) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
