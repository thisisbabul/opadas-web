package com.opadas.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.service.AdminService;
import com.opadas.service.PatientService;
import com.opadas.service.PharmacyService;

/**
 * Servlet implementation class PharmacyDashboard
 */
@WebServlet("/patientdashboard")
public class PatientDashboard extends HttpServlet {
	private AdminService adminService;
	private PatientService patientService;
	private ServletContext sc;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		adminService = new AdminService(sc);
		patientService = new PatientService(sc);
		
		String email = session.getAttribute("aemail").toString();
		request.setAttribute("admin", adminService.getAdmin(email));
		request.setAttribute("patientList", patientService.getPatients());
		request.getRequestDispatcher("/view/admin/patientdashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
