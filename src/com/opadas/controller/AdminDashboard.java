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

/**
 * Servlet implementation class AdminDashboard
 */
@WebServlet("/admindashboard")
public class AdminDashboard extends HttpServlet {
	private ServletContext sc;
	private AdminService adminService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		adminService = new AdminService(sc);
		
		String email = session.getAttribute("aemail").toString();
		request.setAttribute("admin", adminService.getAdmin(email));
		request.getRequestDispatcher("/view/admin/admindashboard.jsp").forward(request, response);
	}

}
