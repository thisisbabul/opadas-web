package com.opadas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.model.Doctor;

public class DoctorDao implements CommonDao<Doctor> {
	private ServletContext sc;
	private Connection con = null;

	public DoctorDao(ServletContext sc) {
		this.sc = sc;
		this.con = (Connection) sc.getAttribute("connObj");
	}

	@Override
	public boolean insert(Doctor doctor) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into doctor(name,qualification,expertise,organization,chamber,location,visitinghours,phone,email,password,status,photo)values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getQualification());
			ps.setString(3, doctor.getExpertise());
			ps.setString(4, doctor.getOrganization());
			ps.setString(5, doctor.getChamber());
			ps.setString(6, doctor.getLocation());
			ps.setString(7, doctor.getVisitinghours());
			ps.setString(8, doctor.getPhone());
			ps.setString(9, doctor.getEmail());
			ps.setString(10, doctor.getPassword());
			ps.setString(11, doctor.getStatus());
			ps.setBlob(12, doctor.getPhoto());
			
			return ps.executeUpdate()>0;
		}
		catch(com.mysql.jdbc.MysqlDataTruncation ex){
			System.out.println("File size high");
		}
		catch (Exception e) {
			System.out.println("Error in insert doctor : " + e);
		}
		return false;
	}
	
	@Override
	public List<Doctor> retriveUsers() {
		List<Doctor> doctorList = new ArrayList<Doctor>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from doctor");

			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setId(rs.getInt("id"));
				doctor.setName(rs.getString("name"));
				doctor.setQualification(rs.getString("qualification"));
				doctor.setExpertise(rs.getString("expertise"));
				doctor.setOrganization(rs.getString("organization"));
				doctor.setChamber(rs.getString("chamber"));
				doctor.setLocation(rs.getString("location"));
				doctor.setVisitinghours(rs.getString("visitinghours"));
				doctor.setPhone(rs.getString("phone"));
				doctor.setEmail(rs.getString("email"));
				doctor.setPassword(rs.getString("password"));
				doctor.setStatus(rs.getString("status"));
				
				doctorList.add(doctor);
			}
			return doctorList;
		} catch (Exception e) {
			System.out.println("Error in Retrive doctor : " + e);
		}
		return null;
	}

	@Override
	public boolean update(Doctor doctor) {
		try {
			PreparedStatement ps = con.prepareStatement("update doctor set name=?, qualification=?, expertise=?, organization=?, chamber=?, location=?, visitinghours=?,phone=?,email=?,password=?,status=? where email=?");
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getQualification());
			ps.setString(3, doctor.getExpertise());
			ps.setString(4, doctor.getOrganization());
			ps.setString(5, doctor.getChamber());
			ps.setString(6, doctor.getLocation());
			ps.setString(7, doctor.getVisitinghours());
			ps.setString(8, doctor.getPhone());
			ps.setString(9, doctor.getEmail());
			ps.setString(10, doctor.getPassword());
			ps.setString(11, doctor.getStatus());
			ps.setString(12, doctor.getEmail());
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in update doctor : " + e);
		}
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
}
