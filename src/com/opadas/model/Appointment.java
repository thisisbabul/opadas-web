package com.opadas.model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	private int id;
	private Date date;
	private int prescriptionId;
	private int patientId;
	private int doctorId;
	private Patient patient;
	private String status;

	public Appointment() {

	}

	public Appointment(Date date, int prescriptionId, int patientId, int doctorId) {
		this.date = date;
		this.prescriptionId = prescriptionId;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

	public Appointment(int id, Date date, int prescriptionId, int patientId, int doctorId) {
		this.id = id;
		this.date = date;
		this.prescriptionId = prescriptionId;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
