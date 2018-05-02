package com.opadas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opadas.model.Doctor;
import com.opadas.service.DoctorService;

@WebServlet("/doctorview")
public class DoctorView extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	
	private static final long serialVersionUID = 1L;

	public DoctorView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		
		List<Doctor> doctorList = doctorService.getDoctors();
		
		request.setAttribute("doctorList", doctorList);
		request.getRequestDispatcher("/view/doctor/doctorlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
