package com.opadas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opadas.model.Doctor;
import com.opadas.model.Patient;
import com.opadas.model.Prescription;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;
import com.opadas.service.PrescriptionService;

/**
 * Servlet implementation class DoctorPresSearch
 */
@WebServlet("/doctorpressearch")
public class DoctorPresSearch extends HttpServlet {
	private ServletContext sc;
	private PrescriptionService prescriptionService;
	private DoctorService doctorService;
	private PatientService patientService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorPresSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int presid = Integer.parseInt(request.getParameter("prescriptionid"));
		sc = getServletContext();
		prescriptionService = new PrescriptionService(sc);
		doctorService = new DoctorService(sc);
		patientService = new PatientService(sc);
		
		String email = session.getAttribute("demail").toString();
		Doctor doctor = doctorService.getDoctor(email);
		
		List<Prescription> presList = prescriptionService.getPrescriptions(doctor.getId());
		
		List<Prescription> newpresList = new ArrayList<>();
		
		List<Prescription> spresList = new ArrayList<>();
				
		for(Prescription pres:presList){
			Patient patient = patientService.getPatientById(pres.getPatientId());
			pres.setPatient(patient);
			newpresList.add(pres);
		}
		
		for(Prescription p: newpresList){
			if(p.getPrescriptionId()==presid){
				spresList.add(p);
			}
		}
		
		
		request.setAttribute("doctor", doctor);					
		
		request.setAttribute("preslist", spresList);
		request.getRequestDispatcher("/view/doctor/prescriptionlist.jsp").forward(request, response);
	}

}
