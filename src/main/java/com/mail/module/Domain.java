package com.mail.module;

public class Domain {
	private static int id;
	private String domain;
	private UserMail[] users;
	
	public Domain(String domain, UserMail[] users) {
		super();
		this.domain = domain;
		this.users = users;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Domain.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public UserMail[] getUsers() {
		return users;
	}

	public void setUsers(UserMail[] users) {
		this.users = users;
	}
}
