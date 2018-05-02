package com.opadas.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opadas.model.Doctor;
import com.opadas.service.DoctorService;

/**
 * Servlet implementation class DoctorGetAppoint
 */
@WebServlet("/doctor")
public class DoctorGetAppoint extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorGetAppoint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		
		int id = Integer.parseInt(request.getParameter("id"));
		Doctor doctor = doctorService.getDoctorsById(id);
		if(doctor!=null){
			request.setAttribute("doctor", doctor);
			request.getRequestDispatcher("view/common/doctorprofile.jsp").forward(request, response);
		}
	}

}
