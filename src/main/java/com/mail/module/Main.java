package com.mail.module;


import com.mail.dao.Admindao;
import com.mail.dao.UserMaildao;
import com.mail.functions.IAdmin;
import com.mail.functions.IUserMail;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserMail service=new UserMaildao();
			UserMail usermail=new UserMail("anass","hadaoui","anass@smpt.local",IUserMail.getsh("anass"));
			IAdmin serviceadmin=new Admindao();
			
			if(service.isexiste("anass@smpt.local"))
				System.out.println("Succefull existe");
			else
				service.register(usermail);
			System.out.println(IUserMail.getsh("abdel"));
	}

}
