package com.opadas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opadas.service.DoctorService;

public class Home extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		request.setAttribute("doctorList", doctorService.getDoctors());
		request.getRequestDispatcher("/view/common/home.jsp").forward(request, response);
	}
}
