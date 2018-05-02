package com.opadas.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.opadas.model.Admin;
import com.opadas.service.AdminService;
import com.opadas.service.CommonService;

@WebServlet("/admininsert")
@MultipartConfig(maxFileSize = 16177215)
public class AdminInsert extends HttpServlet {
	private AdminService adminService;
	private ServletContext sc;
	private CommonService commonService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		adminService = new AdminService(sc);
		
		String email = session.getAttribute("aemail").toString();
		request.setAttribute("admin", adminService.getAdmin(email));
		request.getRequestDispatcher("/view/admin/adminadd.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		adminService = new AdminService(sc);
		commonService = new CommonService();

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String aemail = session.getAttribute("aemail").toString();
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String email = request.getParameter("email");
		Random rand = new Random();
		String password = String.valueOf(rand.nextInt(10000));
		String phone = request.getParameter("phone");
		String status = "Active";
		Part part = request.getPart("image");
		InputStream photo = part.getInputStream();

		long photosize = part.getSize();

		if (photosize < 65535) {
			if (!adminService.isEmailExist(email)) {
				Admin admin = new Admin(name, designation, email, password, phone, status, photo);
				boolean isInserted = adminService.insert(admin);

				if (isInserted) {
					commonService.sendEmail(name, email, password);
					request.setAttribute("admin", adminService.getAdmin(aemail));
					pw.println("<script>alert('Registation Successful, please check your mail to know your username and password');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminadd.jsp");
					rd.include(request, response);
				} else {
					request.setAttribute("admin", adminService.getAdmin(aemail));
					pw.println("<script>alert('Admin Registration Failed');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminadd.jsp");
					rd.include(request, response);
				}
			} else {
				request.setAttribute("admin", adminService.getAdmin(aemail));
				pw.println("<script>alert('Your Email Already Exist, please choose another email');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminadd.jsp");
				rd.include(request, response);
			}

		}else {
			request.setAttribute("admin", adminService.getAdmin(aemail));
			pw.println("<script>alert('Your photo size should be less than 65kb');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/adminadd.jsp");
			rd.include(request, response);
		}
	}

}
