package com.opadas.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.opadas.model.Appointment;
import com.opadas.model.Patient;
import com.opadas.service.AppointmentService;
import com.opadas.service.CommonService;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;

@WebServlet("/patientinsert")
@MultipartConfig(maxFileSize = 16177215)
public class PatientInsert extends HttpServlet {
	private ServletContext sc;
	private PatientService patientService;
	private AppointmentService appointmentService;
	private CommonService commonService;
	private DoctorService doctorService;

	private static final long serialVersionUID = 1L;

	public PatientInsert() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		sc = getServletContext();
		patientService = new PatientService(sc);
		appointmentService = new AppointmentService(sc);
		doctorService = new DoctorService(sc);

		commonService = new CommonService();

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		Random rand = new Random();
		String password = String.valueOf(rand.nextInt(10000));
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));

		Part part = request.getPart("image");
		InputStream photo = part.getInputStream();

		long photosize = part.getSize();

		if (name.equals("Name") || address.equals("Address") || mobile.equals("Mobile") || email.equals("E-mail")) {
			request.setAttribute("doctorList", doctorService.getDoctors());
			pw.println("<script>alert('Please fillup all field');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/view/common/home.jsp");
			rd.include(request, response);
		} else {
			if (photosize < 65535) {
				if (!patientService.isEmailExist(email)) {
					Patient patient = new Patient(name, address, mobile, email, password, "Active", photo);
					boolean isInserted = patientService.insert(patient);

					if (isInserted) {
						commonService.sendEmail(name, email, password);
						Patient p = patientService.getPatient(email);
						int patientId = p.getId();

						java.util.Date utilDate = new java.util.Date();

						Calendar c = Calendar.getInstance();
						c.setTime(utilDate);
						c.add(Calendar.DATE, 10);

						java.util.Date date = c.getTime();

						java.sql.Date sqlDate = new java.sql.Date(date.getTime());

						StringTokenizer st = new StringTokenizer(sqlDate.toString(), "-");
						StringBuilder sb = new StringBuilder();
						while (st.hasMoreTokens()) {
							sb.append(st.nextToken());
						}
						String f = String.valueOf(rand.nextInt(10));
						sb.append(f);
						int prescriptionId = appointmentService.getNewPrescriptionId((Integer.valueOf(sb.toString()) * 10));
						Appointment appoint = new Appointment(sqlDate, prescriptionId, patientId, doctorId);
						if (appointmentService.insert(appoint)) {
							pw.println("<script>alert('Appointment Successful, please check your mail to know your username and password');</script>");
							RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
							rd.include(request, response);
						}

					} else {
						
						request.setAttribute("doctorList", doctorService.getDoctors());
						pw.println("<script>alert('Appointment Failed');</script>");
						RequestDispatcher rd = request.getRequestDispatcher("/view/common/home.jsp");
						rd.include(request, response);
					}
				} else {
					
					request.setAttribute("doctorList", doctorService.getDoctors());
					pw.println("<script>alert('Your Email Already Exist, please choose another email');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("/view/common/home.jsp");
					rd.include(request, response);
				}
			} else {
				
				request.setAttribute("doctorList", doctorService.getDoctors());
				pw.println("<script>alert('Your Email Already Exist, please choose another email');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/view/common/home.jsp");
				rd.include(request, response);
			}
		}
	}
}
