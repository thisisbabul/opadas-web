package com.opadas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import com.opadas.service.AdminService;
import com.opadas.service.AppointmentService;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;
import com.opadas.service.PharmacyService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private ServletContext sc;
	private AdminService adminService;
	private PatientService patientService;
	private AppointmentService appointmentService;
	private DoctorService doctorService;
	private PharmacyService pharmacyService;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("pemail");
		
		Patient patient = patientService.getPatient(email);
		Appointment appoint = appointmentService.getAppointByPatientId(patient.getId());
		Doctor doctor = doctorService.getDoctorsById(appoint.getDoctorId());
		request.setAttribute("appoint", appoint);
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("/view/patient/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		HttpSession session = request.getSession();

		sc = getServletContext();
		adminService = new AdminService(sc);
		patientService = new PatientService(sc);
		appointmentService = new AppointmentService(sc);
		doctorService = new DoctorService(sc);
		pharmacyService = new PharmacyService(sc);

		if (role.equals("admin")) {
			if (adminService.isValidUsernamePassword(email, password)) {
				if (adminService.isUserActive(email)) {
					session.setAttribute("aemail", email);
					session.setAttribute("role", "admin");
					request.setAttribute("admin", adminService.getAdmin(email));
					request.getRequestDispatcher("/view/admin/admindashboard.jsp").forward(request, response);
				} else {
					pw.println("<script>alert('Your Account is Disable, Please contact with administrator');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
					rd.include(request, response);
				}
			} else {
				pw.println("<script>alert('Incorrect email & password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
				rd.include(request, response);
			}
		} else if (role.equals("patient")) {
			if (patientService.isValidUsernamePassword(email, password)) {
				if (patientService.isUserActive(email)) {
					session.setAttribute("role", "patient");
					session.setAttribute("pemail", email);
					Patient patient = patientService.getPatient(email);
					Appointment appoint = appointmentService.getAppointByPatientId(patient.getId());
					Doctor doctor = doctorService.getDoctorsById(appoint.getDoctorId());
					request.setAttribute("appoint", appoint);
					request.setAttribute("doctor", doctor);
					request.setAttribute("patient", patient);
					request.getRequestDispatcher("/view/patient/dashboard.jsp").forward(request, response);
				} else {
					pw.println("<script>alert('Your Account is Disable, Please contact with administrator');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
					rd.include(request, response);
				}
			} else {
				pw.println("<script>alert('Incorrect email & password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
				rd.include(request, response);
			}

		} else if (role.equals("doctor")) {
			
			if (doctorService.isValidUsernamePassword(email, password)) {
				if (doctorService.isUserActive(email)) {
					session.setAttribute("demail", email);
					session.setAttribute("role", "doctor");
					Doctor doctor = doctorService.getDoctor(email);
					List<Appointment> appointList = appointmentService.getAppointByDoctorId(doctor.getId());
					List<Appointment> newappointList = new ArrayList<>();
					List<Patient> patientList = patientService.getPatientsByAppointList(appointList);
					
					for(Appointment appoint:appointList){
						Patient patient = patientService.getPatientById(appoint.getPatientId());
						appoint.setPatient(patient);
						newappointList.add(appoint);
					}
					request.setAttribute("appointList", newappointList);
					request.setAttribute("doctor", doctor);					
					request.getRequestDispatcher("/view/doctor/dashboard.jsp").forward(request, response);
				} else {
					pw.println("<script>alert('Your Account is Disable, Please contact with administrator');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
					rd.include(request, response);
				}
			} else {
				pw.println("<script>alert('Incorrect email & password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
				rd.include(request, response);
			}

		} else if (role.equals("pharmacy")) {
			if (pharmacyService.isValidUsernamePassword(email, password)) {
				if (pharmacyService.isUserActive(email)) {
					session.setAttribute("role", "pharmacy");
					session.setAttribute("phemail", email);
					request.setAttribute("pharmacy", pharmacyService.getPharmacy(email));
					request.getRequestDispatcher("/view/pharmacy/dashboard.jsp").forward(request, response);
				} else {
					pw.println("<script>alert('Your Account is Disable, Please contact with administrator');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
					rd.include(request, response);
				}
			} else {
				pw.println("<script>alert('Incorrect email & password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
				rd.include(request, response);
			}
		} else {
			pw.println("<script>alert('Please enter email or password or role');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
			rd.include(request, response);
		}
	}

}
