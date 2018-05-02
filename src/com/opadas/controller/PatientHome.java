package com.opadas.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Appointment;
import com.opadas.model.Doctor;
import com.opadas.model.Patient;
import com.opadas.service.AppointmentService;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;

/**
 * Servlet implementation class PatientHome
 */
@WebServlet("/patienthome")
public class PatientHome extends HttpServlet {
	private ServletContext sc;
	private PatientService patientService;
	private AppointmentService appointmentService;
	private DoctorService doctorService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		patientService = new PatientService(sc);
		appointmentService = new AppointmentService(sc);
		doctorService = new DoctorService(sc);
		
		String email = session.getAttribute("pemail").toString();
		
		Patient patient = patientService.getPatient(email);
		Appointment appoint = appointmentService.getAppointByPatientId(patient.getId());
		Doctor doctor = doctorService.getDoctorsById(appoint.getDoctorId());
		
		request.setAttribute("patient", patient);
		request.setAttribute("appoint", appoint);
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("/view/patient/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
