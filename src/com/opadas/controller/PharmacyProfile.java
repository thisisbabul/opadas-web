package com.opadas.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Pharmacy;
import com.opadas.service.PharmacyService;

/**
 * Servlet implementation class PharmacyProfile
 */
@WebServlet("/pharmacyprofile")
public class PharmacyProfile extends HttpServlet {
	private ServletContext sc;
	private PharmacyService pharmacyService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacyProfile() {
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
		request.getRequestDispatcher("/view/pharmacy/profile.jsp").forward(request, response);
	}

	

}
