package com.mail.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Mysqldao {
	private static Mysqldao uniqueInstance;
	private Mysqldao() {
		
	}
	
	public static Mysqldao getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Mysqldao();
		}
		return uniqueInstance;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Erreur de pilote : " + ex.getMessage());
		}
		try {
			conn =(Connection) DriverManager.getConnection("jdbc:mysql://192.168.239.147:3306/mailserver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "userme","MysqlPostfix22@");

		}
		catch(SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return conn;
	}
	

}
