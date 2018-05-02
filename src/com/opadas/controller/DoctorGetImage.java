package com.opadas.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doctorgetimage")
public class DoctorGetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoctorGetImage() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id=request.getParameter("id");
			ServletContext sc=getServletContext();
			Connection con=(Connection)sc.getAttribute("connObj");
			PreparedStatement st=con.prepareStatement("select photo from doctor where id=?");
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
            while(rs.next()){

            	Blob image = rs.getBlob(1);
            
            	
            	byte[] imaData = image.getBytes(1, (int) image.length());
            	OutputStream output = response.getOutputStream();
            	response.setContentType("image/gif");
            	output.write(imaData);
            	output.flush();
            	output.close();
            }
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in GetIamge : "+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
