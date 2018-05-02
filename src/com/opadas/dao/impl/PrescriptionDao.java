package com.opadas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.model.Patient;
import com.opadas.model.Prescription;

public class PrescriptionDao implements CommonDao<Prescription> {
	private ServletContext sc;
	private Connection con = null;

	public PrescriptionDao(ServletContext sc) {
		this.sc = sc;
		this.con = (Connection) sc.getAttribute("connObj");
	}

	@Override
	public boolean insert(Prescription prescription) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into prescription(age,gender,date,prescriptionid,height,weight,bloodgroup,bloodpressure,temperature,diseasename,type,medicinename,mgml,dos,comments,testname,description,advice,patientid,doctorid)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, prescription.getAge());
			ps.setString(2, prescription.getGender());
			ps.setDate(3, prescription.getDate());
			ps.setInt(4, prescription.getPrescriptionId());
			ps.setString(5, prescription.getHeight());
			ps.setString(6, prescription.getWeight());
			ps.setString(7, prescription.getBloodGroup());
			ps.setString(8, prescription.getBloodPressure());
			ps.setString(9, prescription.getTemperature());
			ps.setString(10, prescription.getDiseaseName());
			ps.setString(11, prescription.getType());
			ps.setString(12, prescription.getMedicineName());
			ps.setString(13, prescription.getMgml());
			ps.setString(14, prescription.getDos());
			ps.setString(15, prescription.getComments());
			ps.setString(16, prescription.getTestName());
			ps.setString(17, prescription.getDescription());
			ps.setString(18, prescription.getAdvice());
			ps.setInt(19, prescription.getPatientId());
			ps.setInt(20, prescription.getDoctorId());
			
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in insert prescription : " + e);
		}
		return false;
	}
	
	@Override
	public List<Prescription> retriveUsers() {
		List<Prescription> prescriptionList = new ArrayList<Prescription>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from prescription");

			while (rs.next()) {
				Prescription prescription = new Prescription();
				prescription.setId(rs.getInt("id"));
				prescription.setAge(rs.getInt("age"));
				prescription.setGender(rs.getString("gender"));
				prescription.setDate(rs.getDate("date"));
				prescription.setPrescriptionId(rs.getInt("prescriptionid"));
				prescription.setHeight(rs.getString("height"));
				prescription.setWeight(rs.getString("weight"));
				prescription.setBloodGroup(rs.getString("bloodgroup"));
				prescription.setBloodPressure(rs.getString("bloodpressure"));
				prescription.setTemperature(rs.getString("temperature"));
				prescription.setDiseaseName(rs.getString("diseasename"));
				prescription.setType(rs.getString("type"));
				prescription.setMedicineName(rs.getString("medicinename"));
				prescription.setMgml(rs.getString("mgml"));
				prescription.setDos(rs.getString("dos"));
				prescription.setComments(rs.getString("comments"));
				prescription.setTestName(rs.getString("testname"));
				prescription.setDescription(rs.getString("description"));
				prescription.setAdvice(rs.getString("advice"));
				prescription.setPatientId(rs.getInt("patientid"));
				prescription.setDoctorId(rs.getInt("doctorid"));
				prescriptionList.add(prescription);
			}
			return prescriptionList;
		} catch (Exception e) {
			System.out.println("Error in Retrive patient : " + e);
		}
		return null;
	}

	@Override
	public boolean update(Prescription prescription) {
		try {
			PreparedStatement ps = con.prepareStatement("update prescription set age = ?, gender=?, date=?, prescriptionid=?, height=?,weight=?,bloodgroup=?,bloodpressure=?,temperature=?,diseasename=?,type=?,medicinename=?,mgml=?,dos=?,comments=?,testname=?,description=?,advice=?,patientid=?,doctorid=?, where prescriptionid=?");
			ps.setInt(1, prescription.getAge());
			ps.setString(2, prescription.getGender());
			ps.setDate(3, prescription.getDate());
			ps.setInt(4, prescription.getPrescriptionId());
			ps.setString(5, prescription.getHeight());
			ps.setString(6, prescription.getWeight());
			ps.setString(7, prescription.getBloodGroup());
			ps.setString(8, prescription.getBloodPressure());
			ps.setString(9, prescription.getTemperature());
			ps.setString(10, prescription.getDiseaseName());
			ps.setString(11, prescription.getType());
			ps.setString(12, prescription.getMedicineName());
			ps.setString(13, prescription.getMgml());
			ps.setString(14, prescription.getDos());
			ps.setString(15, prescription.getComments());
			ps.setString(16, prescription.getTestName());
			ps.setString(17, prescription.getDescription());
			ps.setString(18, prescription.getAdvice());
			ps.setInt(19, prescription.getPatientId());
			ps.setInt(20, prescription.getDoctorId());
			ps.setInt(21, prescription.getPrescriptionId());
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in update prescription : " + e);
		}
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
}
