package com.mail.module;

import javax.mail.Message;

public class Alias { 
	private UserMail  source;
	private UserMail[] dest;
	private static Message[] emailmsgs;
	public UserMail getSource() {
		return source;
	}
	public void setSource(UserMail source) {
		this.source = source;
	}
	public UserMail[] getDest() {
		return dest;
	}
	public void setDest(UserMail[] dest) {
		this.dest = dest;
	}
	public static Message[] getEmailmsgs() {
		return emailmsgs;
	}
	public static void setEmailmsgs(Message[] emailmsgs) {
		Alias.emailmsgs = emailmsgs;
	}
	
	
	
	

}
