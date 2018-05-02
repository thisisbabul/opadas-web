package com.opadas.model;

import java.io.InputStream;

public class Doctor {
	private int id;
	private String name;
	private String qualification;
	private String expertise;
	private String organization;
	private String chamber;
	private String location;
	private String visitinghours;
	private String phone;
	private String email;
	private String password;
	private String status;
	private InputStream photo;

	public Doctor() {

	}

	public Doctor(String name, String qualification, String expertise, String organization, String chamber,
			String location, String visitinghours, String phone, String email, String password, String status,
			InputStream photo) {
		this.name = name;
		this.qualification = qualification;
		this.expertise = expertise;
		this.organization = organization;
		this.chamber = chamber;
		this.location = location;
		this.visitinghours = visitinghours;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.status = status;
		this.photo = photo;
	}

	public Doctor(int id, String name, String qualification, String expertise, String organization, String chamber,
			String location, String visitinghours, String phone, String email, String password, String status,
			InputStream photo) {
		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.expertise = expertise;
		this.organization = organization;
		this.chamber = chamber;
		this.location = location;
		this.visitinghours = visitinghours;
		this.phone = phone;
		this.email = email;
		this.password = password;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getChamber() {
		return chamber;
	}

	public void setChamber(String chamber) {
		this.chamber = chamber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVisitinghours() {
		return visitinghours;
	}

	public void setVisitinghours(String visitinghours) {
		this.visitinghours = visitinghours;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
