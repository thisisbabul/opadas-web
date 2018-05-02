package com.opadas.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class GetPrescription
 */
@WebServlet("/getprescription")
public class GetPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPrescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int presid = Integer.parseInt(request.getParameter("prescriptionid"));
		Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lict", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //File reportFile = new File(application.getRealPath("report_name.jasper"));//your report_name.jasper file
        JasperReport reporte = null;
		try {
			reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("/report/prescription.jasper"));
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map parameters = new HashMap();
        parameters.put("prescriptionid", presid);
        byte[] bytes=null;
		try {
			bytes = JasperRunManager.runReportToPdf(reporte, parameters, conn);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0, bytes.length);
        outStream.flush();
        outStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
