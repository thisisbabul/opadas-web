package com.opadas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.model.Appointment;
import com.opadas.model.Patient;

public class AppointmentDao implements CommonDao<Appointment> {
	private ServletContext sc;
	private Connection con = null;

	public AppointmentDao(ServletContext sc) {
		this.sc = sc;
		this.con = (Connection) sc.getAttribute("connObj");
	}

	@Override
	public boolean insert(Appointment appoint) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into appointment(date,prescriptionId,patientId,doctorId)values(?,?,?,?)");
			ps.setDate(1, appoint.getDate());
			ps.setInt(2, appoint.getPrescriptionId());
			ps.setInt(3, appoint.getPatientId());
			ps.setInt(4, appoint.getDoctorId());
						
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in insert appointment : " + e);
		}
		return false;
	}
	
	@Override
	public List<Appointment> retriveUsers() {
		List<Appointment> appointList = new ArrayList<Appointment>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from appointment");

			while (rs.next()) {
				Appointment appoint = new Appointment();
				appoint.setId(rs.getInt("id"));
				appoint.setDate(rs.getDate("date"));
				appoint.setPrescriptionId(rs.getInt("prescriptionId"));
				appoint.setPatientId(rs.getInt("patientId"));
				appoint.setDoctorId(rs.getInt("doctorId"));
				appoint.setStatus(rs.getString("status"));
				appointList.add(appoint);
			}
			return appointList;
		} catch (Exception e) {
			System.out.println("Error in Retrive appointment : " + e);
		}
		return null;
	}

	@Override
	public boolean update(Appointment appoint) {
		try {
			PreparedStatement ps = con.prepareStatement("update appointment set date = ?, prescriptionId=?, patientId=?,doctorId=?,status=? where prescriptionId=?");
			ps.setDate(1, appoint.getDate());
			ps.setInt(2, appoint.getPrescriptionId());
			ps.setInt(3, appoint.getPatientId());
			ps.setInt(4, appoint.getDoctorId());
			ps.setString(5, appoint.getStatus());
			ps.setInt(6, appoint.getPrescriptionId());
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in update appointment : " + e);
		}
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
}
