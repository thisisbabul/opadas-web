package com.opadas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Doctor;
import com.opadas.model.Patient;
import com.opadas.model.Prescription;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;
import com.opadas.service.PrescriptionService;

/**
 * Servlet implementation class PatientPresSearch
 */
@WebServlet("/patientpressearch")
public class PatientPresSearch extends HttpServlet {
	private ServletContext sc;
	private PatientService patientService;
	private PrescriptionService prescriptionService;
	private DoctorService doctorService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientPresSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = session.getAttribute("pemail").toString();
		
		sc = getServletContext();
		prescriptionService = new PrescriptionService(sc);
		doctorService = new DoctorService(sc);
		patientService = new PatientService(sc);
		
		Patient p = patientService.getPatient(email);
		
		Prescription prescription = prescriptionService.getPrescriptionByPatientId(p.getId());
		
		prescription.setPatient(p);
		
		Doctor doctor = doctorService.getDoctorsById(prescription.getDoctorId());
		
		prescription.setDoctor(doctor);
		
		request.setAttribute("patient", p);					
		
		request.setAttribute("pres", prescription);
		request.getRequestDispatcher("/view/patient/patientpressearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = session.getAttribute("pemail").toString();
		int presid = Integer.parseInt(request.getParameter("prescriptionid"));
		sc = getServletContext();
		prescriptionService = new PrescriptionService(sc);
		doctorService = new DoctorService(sc);
		patientService = new PatientService(sc);
		
		
		Prescription prescription = prescriptionService.getPrescriptionByPrescriptionId(presid);
		
		Patient patient = patientService.getPatientById(prescription.getPatientId());
		
		prescription.setPatient(patient);
		
		Patient p = patientService.getPatient(email);
		
		request.setAttribute("patient", p);					
		
		request.setAttribute("pres", prescription);
		request.getRequestDispatcher("/view/patient/patientpressearch.jsp").forward(request, response);
	}

}
