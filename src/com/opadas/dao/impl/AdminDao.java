package com.opadas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.model.Admin;

public class AdminDao implements CommonDao<Admin> {
	private ServletContext sc;
	private Connection con = null;

	public AdminDao(ServletContext sc) {
		this.sc = sc;
		this.con = (Connection)sc.getAttribute("connObj");
	}

	@Override
	public boolean insert(Admin admin) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into admin(name,designation,email,password,phone,status,photo)values(?,?,?,?,?,?,?)");
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getDesignation());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getPassword());
			ps.setString(5, admin.getPhone());
			ps.setString(6, admin.getStatus());
			ps.setBlob(7, admin.getPhoto());
						
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in insert admin : " + e);
		}
		return false;
	}

	@Override
	public List<Admin> retriveUsers() {
		List<Admin> list=new ArrayList<>();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from admin");
			while(rs.next())
			{
				Admin admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setDesignation(rs.getString("designation"));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone"));
				admin.setStatus(rs.getString("status"));
				list.add(admin);
			}
			return list;
		}catch (Exception e) {
            System.out.println("Error in Retrive Student : "+e);
		}
		return null;
	}

	@Override
	public boolean update(Admin admin) {
		try {
			PreparedStatement ps = con.prepareStatement("update admin set name = ?, designation=?, email=?, password=?, phone=?, status=? where email=?");
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getDesignation());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getPassword());
			ps.setString(5, admin.getPhone());
			ps.setString(6, admin.getStatus());
			ps.setString(7, admin.getEmail());
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in update admin : " + e);
		}
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
