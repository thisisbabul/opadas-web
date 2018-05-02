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
import com.opadas.service.DoctorService;

/**
 * Servlet implementation class DoctorProfile
 */
@WebServlet("/doctorprofile")
public class DoctorProfile extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		HttpSession session = request.getSession();
		String email = session.getAttribute("demail").toString();
		
		Doctor doctor = doctorService.getDoctor(email);
		
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("/view/doctor/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
