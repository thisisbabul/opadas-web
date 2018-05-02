package com.opadas.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Doctor;
import com.opadas.model.Patient;
import com.opadas.model.Pharmacy;
import com.opadas.model.Prescription;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;
import com.opadas.service.PharmacyService;
import com.opadas.service.PrescriptionService;

/**
 * Servlet implementation class PharmacyPresSearch
 */
@WebServlet("/pharmacypressearch")
public class PharmacyPresSearch extends HttpServlet {
	private ServletContext sc;
	private PharmacyService pharmacyService;
	private PatientService patientService;
	private DoctorService doctorService;
	private PrescriptionService prescriptionService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacyPresSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		pharmacyService = new PharmacyService(sc);
				
		String email = session.getAttribute("phemail").toString();
		
		Pharmacy pharmacy = pharmacyService.getPharmacy(email);
				
		request.setAttribute("pharmacy", pharmacy);
		request.getRequestDispatcher("/view/pharmacy/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		pharmacyService = new PharmacyService(sc);
		patientService = new PatientService(sc);
		doctorService = new DoctorService(sc);
		prescriptionService = new PrescriptionService(sc);
		
		int presid = Integer.parseInt(request.getParameter("prescriptionid"));
		
		Prescription prescription = prescriptionService.getPrescriptionByPrescriptionId(presid);
		Doctor doctor = doctorService.getDoctorsById(prescription.getDoctorId());
		Patient patient = patientService.getPatientById(prescription.getPatientId());
		prescription.setDoctor(doctor);
		prescription.setPatient(patient);
		
		
		String email = session.getAttribute("phemail").toString();
		
		Pharmacy pharmacy = pharmacyService.getPharmacy(email);
				
		request.setAttribute("pharmacy", pharmacy);
		request.setAttribute("pres", prescription);
		request.getRequestDispatcher("/view/pharmacy/dashboard.jsp").forward(request, response);
	}

}
