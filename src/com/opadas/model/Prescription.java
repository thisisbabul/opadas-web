package com.opadas.model;

import java.sql.Date;

public class Prescription {
	private int id;
	private int age;
	private String gender;
	private Date date;
	private int prescriptionId;
	private String height;
	private String weight;
	private String bloodGroup;
	private String bloodPressure;
	private String temperature;
	private String diseaseName;
	private String type;
	private String medicineName;
	private String mgml;
	private String dos;
	private String comments;
	private String testName;
	private String description;
	private String advice;
	private int patientId;
	private int doctorId;
	private Patient patient;
	private Doctor doctor;

	public Prescription() {

	}

	public Prescription(int id, int age, String gender, Date date, int prescriptionId, String height, String weight,
			String bloodGroup, String bloodPressure, String temperature, String diseaseName, String type,
			String medicineName, String mgml, String dos, String commonts, String testName, String description,
			String advice, int patientId, int doctorId) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.date = date;
		this.prescriptionId = prescriptionId;
		this.height = height;
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.bloodPressure = bloodPressure;
		this.temperature = temperature;
		this.diseaseName = diseaseName;
		this.type = type;
		this.medicineName = medicineName;
		this.mgml = mgml;
		this.dos = dos;
		this.comments = commonts;
		this.testName = testName;
		this.description = description;
		this.advice = advice;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

	public Prescription(int age, String gender, Date date, int prescriptionId, String height, String weight,
			String bloodGroup, String bloodPressure, String temperature, String diseaseName, String type,
			String medicineName, String mgml, String dos, String commonts, String testName, String description,
			String advice, int patientId, int doctorId) {
		super();
		this.age = age;
		this.gender = gender;
		this.date = date;
		this.prescriptionId = prescriptionId;
		this.height = height;
		this.weight = weight;
		this.bloodGroup = bloodGroup;
		this.bloodPressure = bloodPressure;
		this.temperature = temperature;
		this.diseaseName = diseaseName;
		this.type = type;
		this.medicineName = medicineName;
		this.mgml = mgml;
		this.dos = dos;
		this.comments = commonts;
		this.testName = testName;
		this.description = description;
		this.advice = advice;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMgml() {
		return mgml;
	}

	public void setMgml(String mgml) {
		this.mgml = mgml;
	}

	public String getDos() {
		return dos;
	}

	public void setDos(String dos) {
		this.dos = dos;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String commonts) {
		this.comments = commonts;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
