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

import com.opadas.model.Appointment;
import com.opadas.model.Doctor;
import com.opadas.model.Patient;
import com.opadas.model.Prescription;
import com.opadas.service.AppointmentService;
import com.opadas.service.CommonService;
import com.opadas.service.DoctorService;
import com.opadas.service.PatientService;
import com.opadas.service.PrescriptionService;

/**
 * Servlet implementation class DoctorPrescription
 */
@WebServlet("/prescription")
public class DoctorPrescription extends HttpServlet {
	private ServletContext sc;
	private DoctorService doctorService;
	private PatientService patientService;
	private AppointmentService appointmentService;
	private PrescriptionService prescriptionService;
	private CommonService commonService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorPrescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		doctorService = new DoctorService(sc);
		appointmentService = new AppointmentService(sc);
		patientService = new PatientService(sc);
	
		HttpSession session = request.getSession();
		String email = session.getAttribute("demail").toString();
		int pid = Integer.parseInt(request.getParameter("pid"));
		int aid = Integer.parseInt(request.getParameter("aid"));
		
		
		Doctor doctor = doctorService.getDoctor(email);
		Appointment appoint = appointmentService.getAppointById(aid);
		Patient patient = patientService.getPatientById(pid);
		
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    appoint.setDate(sqlDate);
	    
		request.setAttribute("doctor", doctor);
		request.setAttribute("appoint", appoint);
		request.setAttribute("patient", patient);
		request.getRequestDispatcher("/view/doctor/prescription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sc = getServletContext();
		HttpSession session = request.getSession();
		doctorService = new DoctorService(sc);
		prescriptionService = new PrescriptionService(sc);
		appointmentService = new AppointmentService(sc);
		patientService = new PatientService(sc);
		commonService = new CommonService();
		
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date date = new java.sql.Date(utilDate.getTime());
	    
	    int prescriptionid = Integer.parseInt(request.getParameter("prescriptionid"));
	    String height = request.getParameter("height");
	    String weight = request.getParameter("weight");
	    String bloodgroup = request.getParameter("bloodgroup");
	    String bloodpressure = request.getParameter("bloodpressure");
	    String temperature = request.getParameter("temperature");
	    String diseasename = request.getParameter("diseasename");
	    String type = request.getParameter("type");
	    String medicinename = request.getParameter("medicinename");
	    String mgml = request.getParameter("mgml");
	    String dos = request.getParameter("dos");
	    String comments = request.getParameter("comments");
	    String testname = request.getParameter("testname");
	    String description = request.getParameter("description");
	    String advice = request.getParameter("advice");
	    int patientid = Integer.parseInt(request.getParameter("patientid"));
	    int doctorid = Integer.parseInt(request.getParameter("doctorid"));
	    
	    Prescription prescription = new Prescription(age, gender, date, prescriptionid, height, weight, bloodgroup, bloodpressure, temperature, diseasename, type, medicinename, mgml, dos, comments, testname, description, advice, patientid, doctorid);
	    if(prescriptionService.insert(prescription)){
	    	Appointment appointment = appointmentService.getAppointByPrescriptionId(prescriptionid);
	    	appointment.setStatus("ok");
	    	if(appointmentService.update(appointment)){
	    		Patient patient = patientService.getPatientById(patientid);
	    		commonService.sendEmail(patient.getName(), patient.getEmail(), prescriptionid);
	    		
	    		
	    		String email = session.getAttribute("demail").toString();
	    		Doctor doctor = doctorService.getDoctor(email);
	    		List<Appointment> appointList = appointmentService.getAppointByDoctorId(doctor.getId());
	    		List<Appointment> newappointList = new ArrayList<>();
	    				
	    		for(Appointment appoint:appointList){
	    			Patient dpatient = patientService.getPatientById(appoint.getPatientId());
	    			appoint.setPatient(dpatient);
	    			newappointList.add(appoint);
	    		}
	    		request.setAttribute("appointList", newappointList);
	    		request.setAttribute("doctor", doctor);		
	    		
	    		request.getRequestDispatcher("/view/doctor/dashboard.jsp").forward(request, response);
	    	}
	    }
	}

}
