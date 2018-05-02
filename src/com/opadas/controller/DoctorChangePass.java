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
import com.opadas.service.DoctorService;

/**
 * Servlet implementation class DoctorChangePass
 */
@WebServlet("/doctorchangepass")
public class DoctorChangePass extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		HttpSession session = request.getSession();
		String email = session.getAttribute("demail").toString();
		
		request.setAttribute("doctor", doctorService.getDoctor(email));
		request.getRequestDispatcher("/view/doctor/changepass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		
		HttpSession session = request.getSession();
		String email = session.getAttribute("demail").toString();
		String opass = request.getParameter("opass");
		String npass = request.getParameter("npass");
		
		if(doctorService.isValidUsernamePassword(email,opass)){
			if(doctorService.changePassword(email, npass)){
				request.setAttribute("doctor", doctorService.getDoctor(email));
				pw.println("<script>alert('Password has been changed');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/doctor/changepass.jsp");
				rd.include(request, response);
			}else{
				request.setAttribute("doctor", doctorService.getDoctor(email));
				pw.println("<script>alert('Error occured to change password');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/doctor/changepass.jsp");
				rd.include(request, response);
			}
		}else{
			request.setAttribute("doctor", doctorService.getDoctor(email));
			pw.println("<script>alert('Old Password is not correct');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/doctor/changepass.jsp");
			rd.include(request, response);
		}
		
	}

}
