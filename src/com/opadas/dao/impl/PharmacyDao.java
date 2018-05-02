package com.opadas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.opadas.dao.CommonDao;
import com.opadas.model.Pharmacy;

public class PharmacyDao implements CommonDao<Pharmacy> {
	private ServletContext sc;
	private Connection con = null;

	public PharmacyDao(ServletContext sc) {
		this.sc = sc;
		this.con = (Connection)sc.getAttribute("connObj");
	}

	@Override
	public boolean insert(Pharmacy pharmacy) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into pharmacy(pharmacyname,ownerofpharmacy,address,email,password,phone,status,photo)values(?,?,?,?,?,?,?,?)");
			ps.setString(1, pharmacy.getPharmacyName());
			ps.setString(2, pharmacy.getOwnerOfPharmacy());
			ps.setString(3, pharmacy.getAddress());
			ps.setString(4, pharmacy.getEmail());
			ps.setString(5, pharmacy.getPassword());
			ps.setString(6, pharmacy.getPhone());
			ps.setString(7, pharmacy.getStatus());
			ps.setBlob(8, pharmacy.getPhoto());
						
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in insert pharmacy : " + e);
		}
		return false;
	}

	@Override
	public List<Pharmacy> retriveUsers() {
		List<Pharmacy> list=new ArrayList<>();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from pharmacy");
			while(rs.next())
			{
				Pharmacy pharmacy=new Pharmacy();
				pharmacy.setId(rs.getInt("id"));
				pharmacy.setPharmacyName(rs.getString("pharmacyName"));
				pharmacy.setOwnerOfPharmacy(rs.getString("ownerofpharmacy"));
				pharmacy.setAddress(rs.getString("address"));
				pharmacy.setEmail(rs.getString("email"));
				pharmacy.setPassword(rs.getString("password"));
				pharmacy.setPhone(rs.getString("phone"));
				pharmacy.setStatus(rs.getString("status"));
				list.add(pharmacy);
			}
			return list;
		}catch (Exception e) {
            System.out.println("Error in Retrive Pharmacy : "+e);
		}
		return null;
	}

	@Override
	public boolean update(Pharmacy pharmacy) {
		try {
			PreparedStatement ps = con.prepareStatement("update pharmacy set pharmacyname = ?, ownerofpharmacy=?, address=?, email=?, password=?, phone=?, status=? where email=?");
			ps.setString(1, pharmacy.getPharmacyName());
			ps.setString(2, pharmacy.getOwnerOfPharmacy());
			ps.setString(3, pharmacy.getAddress());
			ps.setString(4, pharmacy.getEmail());
			ps.setString(5, pharmacy.getPassword());
			ps.setString(6, pharmacy.getPhone());
			ps.setString(7, pharmacy.getStatus());
			ps.setString(8, pharmacy.getEmail());
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			System.out.println("Error in update Pharmacy : " + e);
		}
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
