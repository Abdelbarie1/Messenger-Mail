package com.mail.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mail.functions.IAdmin;
import com.mail.module.Admin;
import com.mail.module.UserMail;


public class Admindao implements IAdmin {

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("static-access")
			Connection conn = Mysqldao.getInstance().getConnection();
			PreparedStatement pst;
			pst = conn.prepareStatement("SELECT * FROM admin WHERE email=? AND password=?");
		
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return true;
		}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("static-access")
			Connection conn = Mysqldao.getInstance().getConnection();
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO admin (fullname, email, password)\r\n"
					+ "VALUES (?,?,?);");
			stmt.setString(1, admin.getFullname());
			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getPasswrod());
			stmt.execute();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addUsermail(UserMail usermail) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("static-access")
			Connection conn = Mysqldao.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO virtual_users (first_name, last_name, domain_id, email, password)\r\n"
					+ "VALUES (?,?,?,?,?);");
			stmt.setString(1, usermail.getFirst_name());
			stmt.setString(2, usermail.getLast_name());
			stmt.setInt(3, 1);
			stmt.setString(4, usermail.getEmail());
			stmt.setString(5, usermail.getPassword());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUserMail(int id) {
		// TODO Auto-generated method stub
			try {
				@SuppressWarnings("static-access")
				Connection conn = Mysqldao.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM virtual_users WHERE id = ?");
				stmt.setInt(1, id);
				stmt.execute();
			} catch (SQLException ex) {
				System.out.println("Erreur SQL : " + ex.getMessage());
			}
	}
	
}
