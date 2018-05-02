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

import com.opadas.service.AdminService;
import com.opadas.service.PharmacyService;

/**
 * Servlet implementation class PharmacyChangepass
 */
@WebServlet("/pharmacychangepass")
public class PharmacyChangepass extends HttpServlet {
	private ServletContext sc;
	private PharmacyService pharmacyService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacyChangepass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		pharmacyService = new PharmacyService(sc);
		HttpSession session = request.getSession();
		String email = session.getAttribute("phemail").toString();
		
		request.setAttribute("pharmacy", pharmacyService.getPharmacy(email));
		request.getRequestDispatcher("/view/pharmacy/changepass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		sc = getServletContext();
		pharmacyService = new PharmacyService(sc);
		
		HttpSession session = request.getSession();
		String email = session.getAttribute("phemail").toString();
		String opass = request.getParameter("opass");
		String npass = request.getParameter("npass");
		
		if(pharmacyService.isValidUsernamePassword(email,opass)){
			if(pharmacyService.changePassword(email, npass)){
				request.setAttribute("pharmacy", pharmacyService.getPharmacy(email));
				pw.println("<script>alert('Password has been changed');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/pharmacy/changepass.jsp");
				rd.include(request, response);
			}else{
				request.setAttribute("pharmacy", pharmacyService.getPharmacy(email));
				pw.println("<script>alert('Error occured to change password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/pharmacy/changepass.jsp");
				rd.include(request, response);
			}
		}else{
			request.setAttribute("pharmacy", pharmacyService.getPharmacy(email));
			pw.println("<script>alert('Old Password is not correct');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/pharmacy/changepass.jsp");
			rd.include(request, response);
		}
	}

}
