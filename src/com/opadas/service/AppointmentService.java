package com.opadas.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.dao.impl.AppointmentDao;
import com.opadas.model.Appointment;

public class AppointmentService {
	private CommonDao<Appointment> appointDao;

	public AppointmentService(ServletContext sc) {
		appointDao = new AppointmentDao(sc);
	}

	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return appointDao.retriveUsers();
	}
	
	
	public boolean insert(Appointment appoint) {
		return appointDao.insert(appoint);
	}


	public boolean update(Appointment a) {
		List<Appointment> appointList = appointDao.retriveUsers();
		for (Appointment appoint : appointList) {
			if (a.getPrescriptionId()==appoint.getPrescriptionId()) {
				return appointDao.update(a);
			}
		}
		return false;
	}

	public int getNewPrescriptionId(int prescriptionId) {
		List<Appointment> appointList = appointDao.retriveUsers();
		for (Appointment appoint : appointList) {
			if (prescriptionId==appoint.getPrescriptionId()) {
				return appoint.getPrescriptionId()+1;
			}
		}
		return prescriptionId;
	}

	public Appointment getAppointByPatientId(int id) {
		List<Appointment> appointList = appointDao.retriveUsers();
		for (Appointment appoint : appointList) {
			if (id==appoint.getPatientId()) {
				return appoint;
			}
		}
		return null;
	}

	public List<Appointment> getAppointByDoctorId(int id) {
		List<Appointment> newList = new ArrayList<>();
		List<Appointment> appointList = appointDao.retriveUsers();
		for (Appointment appoint : appointList) {
			if (id==appoint.getDoctorId() && appoint.getStatus().equals("pending")) {
				newList.add(appoint);
			}
		}
		return newList;
	}

	public Appointment getAppointById(int id) {
		List<Appointment> appointList = appointDao.retriveUsers();
		for (Appointment appoint : appointList) {
			if (id==appoint.getId()) {
				return appoint;
			}
		}
		return null;
	}

	public Appointment getAppointByPrescriptionId(int prescriptionid) {
		List<Appointment> appointList = appointDao.retriveUsers();
		for (Appointment appoint : appointList) {
			if (prescriptionid==appoint.getPrescriptionId()) {
				return appoint;
			}
		}
		return null;
	}
}
