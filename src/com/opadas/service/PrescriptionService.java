package com.opadas.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.dao.impl.PrescriptionDao;
import com.opadas.model.Prescription;

public class PrescriptionService {
	private CommonDao<Prescription> prescriptionDao;

	public PrescriptionService(ServletContext sc) {
		prescriptionDao = new PrescriptionDao(sc);
	}

	public List<Prescription> getPrescriptions() {
		// TODO Auto-generated method stub
		return prescriptionDao.retriveUsers();
	}

	public boolean insert(Prescription prescription) {
		return prescriptionDao.insert(prescription);
	}

	public List<Prescription> getPrescriptions(int id) {
		List<Prescription> plist = prescriptionDao.retriveUsers();
		List<Prescription> newplist = new ArrayList<>();
		
		for(Prescription p: plist){
			if(p.getDoctorId()==id){
				newplist.add(p);
			}
		}
		return newplist;
	}

	public Prescription getPrescriptionByPrescriptionId(int presid) {
		List<Prescription> plist = prescriptionDao.retriveUsers();
		for(Prescription p:plist){
			if(p.getPrescriptionId()==presid){
				return p;
			}
		}
		return null;
	}

	public Prescription getPrescriptionByPatientId(int id) {
		List<Prescription> plist = prescriptionDao.retriveUsers();
		for(Prescription p:plist){
			if(p.getPatientId()==id){
				return p;
			}
		}
		return null;
	}

	
}
