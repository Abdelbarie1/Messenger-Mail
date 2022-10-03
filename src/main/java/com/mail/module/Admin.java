package com.mail.module;

public class Admin {
	private int id;
	private String fullname;
	private String email;
	private String passwrod;
	
	public Admin(String fullname, String email, String passwrod) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.passwrod = passwrod;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}
