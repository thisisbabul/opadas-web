package com.opadas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Doctor;
import com.opadas.service.AdminService;
import com.opadas.service.DoctorService;
import com.opadas.service.PharmacyService;

@WebServlet("/doctordashboard")
public class DoctorDashboard extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	private AdminService adminService;
	
	private static final long serialVersionUID = 1L;

	public DoctorDashboard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		HttpSession session = request.getSession();
		adminService = new AdminService(sc);
		
		
		String email = session.getAttribute("aemail").toString();
		request.setAttribute("admin", adminService.getAdmin(email));
		
		
		List<Doctor> doctorList = doctorService.getDoctors();
		request.setAttribute("doctorList", doctorList);
		request.setAttribute("admin", adminService.getAdmin(email));
		request.getRequestDispatcher("/view/admin/doctordashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
