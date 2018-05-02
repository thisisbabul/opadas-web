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

import com.opadas.model.Admin;
import com.opadas.service.AdminService;

/**
 * Servlet implementation class AdminUpdate
 */
@WebServlet("/adminupdate")
public class AdminUpdate extends HttpServlet {
	private ServletContext sc;
	private AdminService adminService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		sc = getServletContext();
		adminService = new AdminService(sc);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		Admin admin = new Admin(id,name,designation,email,phone,status);
		
		if(adminService.update(admin)){
			pw.println("<script>alert('Update Successful');</script>");
			request.setAttribute("admin", admin);
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminprofile.jsp");
			rd.include(request, response);
		}else{
			pw.println("<script>alert('Updation failed');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminupdate.jsp");
			rd.include(request, response);
		}
		
	}

}
