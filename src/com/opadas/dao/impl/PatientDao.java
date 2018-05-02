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

public class PatientDao implements CommonDao<Patient> {
	private ServletContext sc;
	private Connection con = null;

	public PatientDao(ServletContext sc) {
		this.sc = sc;
		this.con = (Connection) sc.getAttribute("connObj");
	}

	@Override
	public boolean insert(Patient patient) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into patient(name,address,mobile,email,password,status,photo)values(?,?,?,?,?,?,?)");
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getAddress());
			ps.setString(3, patient.getMobile());
			ps.setString(4, patient.getEmail());
			ps.setString(5, patient.getPassword());
			ps.setString(6, patient.getStatus());
			ps.setBlob(7, patient.getPhoto());		
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in insert patient : " + e);
		}
		return false;
	}
	
	@Override
	public List<Patient> retriveUsers() {
		List<Patient> patientList = new ArrayList<Patient>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from patient");

			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("id"));
				patient.setName(rs.getString("name"));
				patient.setAddress(rs.getString("address"));
				patient.setMobile(rs.getString("mobile"));
				patient.setEmail(rs.getString("email"));
				patient.setPassword(rs.getString("password"));
				patient.setStatus(rs.getString("status"));
				patientList.add(patient);
			}
			return patientList;
		} catch (Exception e) {
			System.out.println("Error in Retrive patient : " + e);
		}
		return null;
	}

	@Override
	public boolean update(Patient patient) {
		try {
			PreparedStatement ps = con.prepareStatement("update patient set name = ?, address=?, mobile=?, email=?, password=?,status=? where email=?");
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getAddress());
			ps.setString(3, patient.getMobile());
			ps.setString(4, patient.getEmail());
			ps.setString(5, patient.getPassword());
			ps.setString(6, patient.getStatus());
			ps.setString(7, patient.getEmail());
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in update patient : " + e);
		}
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
}
