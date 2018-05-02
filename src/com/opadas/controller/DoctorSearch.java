package com.opadas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Admin;
import com.opadas.model.Doctor;
import com.opadas.service.AdminService;
import com.opadas.service.DoctorService;

@WebServlet("/doctorsearch")
public class DoctorSearch extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	private List<Doctor> doctorList = null;
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		
		String expertise = request.getParameter("expertise");
		
		doctorList = doctorService.getDoctorsByExpertise(expertise);
		
		if(doctorList!=null){
			request.setAttribute("doctorList", doctorList);
			request.getRequestDispatcher("/view/common/home.jsp").forward(request, response);
		}else{
			pw.println("<script>alert('Doctor not found as your expected expertised');</script>");
			request.getRequestDispatcher("/view/common/home.jsp").include(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		
		String name = request.getParameter("search");
		
		if(name!=null){
			doctorList = doctorService.getDoctorsByName(name);
		}
		
		
		if(doctorList!=null){
			request.setAttribute("doctorList", doctorList);
			request.getRequestDispatcher("/view/common/home.jsp").forward(request, response);
		}else{
			pw.println("<script>alert('Doctor not found as your expected name');</script>");
			request.getRequestDispatcher("/view/common/home.jsp").include(request, response);
		}
	}

}
