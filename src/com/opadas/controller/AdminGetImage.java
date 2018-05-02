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

/**
 * Servlet implementation class AdminGetImage
 */
@WebServlet("/admingetimage")
public class AdminGetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id=request.getParameter("id");
			ServletContext sc=getServletContext();
			Connection con=(Connection)sc.getAttribute("connObj");
			PreparedStatement st=con.prepareStatement("select photo from admin where id=?");
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

}
