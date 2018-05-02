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

import com.opadas.model.Appointment;
import com.opadas.model.Doctor;
import com.opadas.model.Patient;
import com.opadas.service.AppointmentService;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;

/**
 * Servlet implementation class DoctorHome
 */
@WebServlet("/doctorhome")
public class DoctorHome extends HttpServlet {
	private ServletContext sc;
	private PatientService patientService;
	private AppointmentService appointmentService;
	private DoctorService doctorService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorHome() {
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
		String email = session.getAttribute("demail").toString();
		Doctor doctor = doctorService.getDoctor(email);
		List<Appointment> appointList = appointmentService.getAppointByDoctorId(doctor.getId());
		List<Appointment> newappointList = new ArrayList<>();
				
		for(Appointment appoint:appointList){
			Patient patient = patientService.getPatientById(appoint.getPatientId());
			appoint.setPatient(patient);
			newappointList.add(appoint);
		}
		request.setAttribute("appointList", newappointList);
		request.setAttribute("doctor", doctor);					
		request.getRequestDispatcher("/view/doctor/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
