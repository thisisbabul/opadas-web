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

import com.opadas.model.Pharmacy;
import com.opadas.service.AdminService;
import com.opadas.service.CommonService;
import com.opadas.service.PharmacyService;

/**
 * Servlet implementation class PharmacyAdd
 */
@WebServlet("/pharmacyadd")
@MultipartConfig(maxFileSize = 16177215)
public class PharmacyAdd extends HttpServlet {
	private ServletContext sc;
	private PharmacyService pharmacyService;
	private CommonService commonService;
	private AdminService adminService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacyAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		sc = getServletContext();
		adminService = new AdminService(sc);
		
		String email = session.getAttribute("aemail").toString();
		request.setAttribute("admin", adminService.getAdmin(email));
		request.getRequestDispatcher("/view/admin/pharmacyadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		pharmacyService = new PharmacyService(sc);
		commonService = new CommonService();
		adminService = new AdminService(sc);
		HttpSession session = request.getSession();
		String aemail = session.getAttribute("aemail").toString();

		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String pharmacyname = request.getParameter("pharmacyname");
		String ownerofpharmacy = request.getParameter("ownerofpharmacy");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		Random rand = new Random();
		String password = String.valueOf(rand.nextInt(10000));
		String phone = request.getParameter("phone");
		String status = "Active";
		Part part = request.getPart("image");
		InputStream photo = part.getInputStream();

		long photosize = part.getSize();

		if (photosize < 65535) {
			if (!pharmacyService.isEmailExist(email)) {
				Pharmacy pharmacy = new Pharmacy(pharmacyname, ownerofpharmacy, address, email, password, phone, status, photo);
				boolean isInserted = pharmacyService.insert(pharmacy);

				if (isInserted) {
					commonService.sendEmail(ownerofpharmacy, email, password);
					request.setAttribute("pharmacyList", pharmacyService.getPharmacies());
					request.setAttribute("admin", adminService.getAdmin(aemail));
					pw.println("<script>alert('Registation Successful, please check your mail to know your username and password');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/admin/pharmacydashboard.jsp");
					rd.include(request, response);
				} else {
					pw.println("<script>alert('Admin Registration Failed');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/admin/register.jsp");
					rd.include(request, response);
				}
			} else {
				pw.println("<script>alert('Your Email Already Exist, please choose another email');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/admin/register.jsp");
				rd.include(request, response);
			}

		}else {
			pw.println("<script>alert('Your photo size should be less than 65kb');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/register.jsp");
			rd.include(request, response);
		}
	}

}
