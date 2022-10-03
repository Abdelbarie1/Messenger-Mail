package com.mail.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mail.functions.IUserMail;
import com.mail.module.UserMail;

public class UserMaildao implements IUserMail  {
	

	public UserMaildao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(String mail, String password) {
		// TODO Auto-generated method stub
		
		try {
			@SuppressWarnings("static-access")
			Connection conn = Mysqldao.getInstance().getConnection();
			
			
			PreparedStatement pst;
			pst = conn.prepareStatement("SELECT * FROM virtual_users WHERE email=? AND password=?");
			pst.setString(1, mail);
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
	public boolean isexiste(String mail) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("static-access")
			Connection conn = Mysqldao.getInstance().getConnection();
			
			
			PreparedStatement pst;
			pst = conn.prepareStatement("SELECT * FROM virtual_users WHERE email=?");
			pst.setString(1, mail);
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
	public void register(UserMail user) {
		// TODO Auto-generated method stub
		
		try {
			@SuppressWarnings("static-access")
			Connection conn = Mysqldao.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO virtual_users (first_name, last_name, domain_id, email, password)\r\n"
					+ "VALUES (?,?,?,?,?);");
			stmt.setString(1, user.getFirst_name());
			stmt.setString(2, user.getLast_name());
			stmt.setInt(3, 1);
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}