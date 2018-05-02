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

import com.opadas.model.Doctor;
import com.opadas.service.AdminService;
import com.opadas.service.CommonService;
import com.opadas.service.DoctorService;

/**
 * Servlet implementation class DoctorInsert
 */
@WebServlet("/doctorinsert")
@MultipartConfig(maxFileSize = 16177215)
public class DoctorInsert extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	private CommonService commonService;
	private AdminService adminService;
	private String password;
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		adminService = new AdminService(sc);
		
		String email = session.getAttribute("aemail").toString();
		request.setAttribute("admin", adminService.getAdmin(email));
		request.getRequestDispatcher("/view/admin/doctoradd.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		adminService = new AdminService(sc);
		
		String aemail = session.getAttribute("aemail").toString();
		
		
		PrintWriter pw = response.getWriter();

		sc = getServletContext();
		doctorService = new DoctorService(sc);
		commonService = new CommonService();

		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		String expertise = request.getParameter("expertise");
		String organization = request.getParameter("organization");
		String chamber = request.getParameter("chamber");
		String location = request.getParameter("location");
		String visitinghours = request.getParameter("visitinghours");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		Random rand = new Random();
		password = String.valueOf(rand.nextInt(10000));

		String status = "Active";
		Part part = request.getPart("image");
		InputStream photo = part.getInputStream();

		long photosize = part.getSize();

		if (photosize < 65535) {
			if (!doctorService.isEmailExist(email)) {
				Doctor doctor = new Doctor(name, qualification, expertise, organization, chamber, location, visitinghours, phone, email, password, status, photo);
				boolean isInserted = doctorService.insert(doctor);
				if (isInserted) {
					commonService.sendEmail(name, email, password);
					request.setAttribute("doctorList", doctorService.getDoctors());
					request.setAttribute("admin", adminService.getAdmin(aemail));
					pw.println("<script>alert('Doctor registation Successful, please check your mail to know your username and password');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/admin/doctordashboard.jsp");
					rd.include(request, response);
				} else {
					pw.println("<script>alert('Doctor Registration Failed..!!');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/admin/doctoradd.jsp");
					rd.include(request, response);
				}
			} else {
				pw.println("<script>alert('Your Email Already Exist, please choose another email');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/admin/doctoradd.jsp");
				rd.include(request, response);
			}
		} else {
			pw.println("<script>alert('Your photo size should be less than 65kb');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/doctoradd.jsp");
			rd.include(request, response);
		}
	}
}
