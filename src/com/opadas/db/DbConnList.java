package com.opadas.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DbConnList
 *
 */
@WebListener
public class DbConnList implements ServletContextListener {

	Connection con=null;
    /**
     * Default constructor. 
     */
    public DbConnList() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stube
    	try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		 	con=DriverManager.getConnection("jdbc:mysql://node151031-opadas.jelastic.regruhosting.ru/opadas", "root", "sk7WtEka39");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/opadas", "root", "");
		 	ServletContext sc=sce.getServletContext();
		 	sc.setAttribute("connObj", con);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in DB Conn : "+e);
		}		
    	
    }

}
