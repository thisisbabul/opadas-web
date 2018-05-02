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

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/adminchangepass")
public class AdminChangePassword extends HttpServlet {
	private AdminService adminService;
	private ServletContext sc;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePassword() {
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
		
		request.setAttribute("admin", adminService.getAdmin(email));
		request.getRequestDispatcher("/view/admin/adminchangepass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		sc = getServletContext();
		adminService = new AdminService(sc);
		
		HttpSession session = request.getSession();
		String email = session.getAttribute("aemail").toString();
		String opass = request.getParameter("opass");
		String npass = request.getParameter("npass");
		
		if(adminService.isValidUsernamePassword(email,opass)){
			if(adminService.changePassword(email, npass)){
				request.setAttribute("admin", adminService.getAdmin(email));
				pw.println("<script>alert('Password has been changed');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/admin/admindashboard.jsp");
				rd.include(request, response);
			}else{
				request.setAttribute("admin", adminService.getAdmin(email));
				pw.println("<script>alert('Error occured to change password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminchangepass.jsp");
				rd.include(request, response);
			}
		}else{
			request.setAttribute("admin", adminService.getAdmin(email));
			pw.println("<script>alert('Old Password is not correct');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminchangepass.jsp");
			rd.include(request, response);
		}
		
	}

}
