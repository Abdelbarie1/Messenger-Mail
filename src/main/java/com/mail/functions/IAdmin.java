package com.mail.functions;

import com.mail.module.Admin;
import com.mail.module.UserMail;

public interface IAdmin {
	public boolean login(String email, String password);
	public void addAdmin(Admin admin);
	public void addUsermail(UserMail usermail);
	public void deleteUserMail(int id);
}
