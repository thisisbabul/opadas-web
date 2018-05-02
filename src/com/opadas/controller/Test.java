package com.opadas.controller;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date utilDate = new java.util.Date();
		
		Calendar c = Calendar.getInstance();
        c.setTime(utilDate);
        c.add(Calendar.DATE, 10);
		
        java.util.Date date = c.getTime();
        
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    String date1 = sqlDate.toString();
	    StringTokenizer st = new StringTokenizer(date1,"-");  
	     while (st.hasMoreTokens()) {  
	         System.out.print(st.nextToken());  
	     }  
	}

}
