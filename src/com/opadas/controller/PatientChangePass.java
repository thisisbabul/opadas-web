package com.opadas.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class PatientChangePass
 */
@WebServlet("/patientchangepass")
public class PatientChangePass extends HttpServlet {
	private ServletContext sc;
	private PatientService patientService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientChangePass() {
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
		
		String email = session.getAttribute("pemail").toString();
		
		Patient patient = patientService.getPatient(email);
		request.setAttribute("patient", patient);
		request.getRequestDispatcher("/view/patient/changepass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		sc = getServletContext();
		patientService = new PatientService(sc);
		
		HttpSession session = request.getSession();
		String email = session.getAttribute("pemail").toString();
		String opass = request.getParameter("opass");
		String npass = request.getParameter("npass");
		
		if(patientService.isValidUsernamePassword(email,opass)){
			if(patientService.changePassword(email, npass)){
				Patient patient = patientService.getPatient(email);
				request.setAttribute("patient", patient);
				pw.println("<script>alert('Password has been changed');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/patient/changepass.jsp");
				rd.include(request, response);
			}else{
				Patient patient = patientService.getPatient(email);
				request.setAttribute("patient", patient);
				pw.println("<script>alert('Error occured to change password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/patient/changepass.jsp");
				rd.include(request, response);
			}
		}else{
			Patient patient = patientService.getPatient(email);
			request.setAttribute("patient", patient);
			pw.println("<script>alert('Old Password is not correct');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/patient/changepass.jsp");
			rd.include(request, response);
		}
		
	}

}
