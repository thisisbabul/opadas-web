package com.opadas.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Admin;
import com.opadas.service.AdminService;

/**
 * Servlet implementation class AdminInfoGet
 */
@WebServlet("/getadmininfo")
public class AdminInfoGet extends HttpServlet {
	private ServletContext sc;
	private AdminService adminService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInfoGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		adminService = new AdminService(sc);
		HttpSession session = request.getSession();
		String email = session.getAttribute("aemail").toString();
		
		Admin admin = adminService.getAdmin(email);
		
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("/view/admin/adminupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
