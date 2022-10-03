package com.mail.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mail.dao.UserMaildao;
import com.mail.functions.IUserMail;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class sendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public sendMail() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		String to = request.getParameter("to").toString();
		String from = session.getAttribute("email").toString();
		final String username = "abdel@mohamed.local"; // somemail does the same
		final String password = "abdel";
		String host = "192.168.239.147";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true"); // same output with mail.smtp.ssl.enable
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 25);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		Session sessionn = Session.getInstance(props, new javax.mail.Authenticator() {
		     protected PasswordAuthentication getPasswordAuthentication() {
		     return new PasswordAuthentication(username, password);
		     }
		});
		sessionn.setDebug(true);
		try {
			 System.out.println("sending ......");
			 Message message = new MimeMessage(sessionn);
		     message.setFrom(new InternetAddress(from));
		     message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		     message.setSubject(request.getParameter("subject").toString());
		     message.setText(request.getParameter("message").toString());
		     message.setSentDate(new Date());
		     Transport.send(message);
		     response.setContentType("text/html");
		     PrintWriter out = response.getWriter() ;
		     out.println("<script type=\"text/javascript\">");
		     out.println("alert(' email Send successfully....');");
		     out.println("window.location.href = 'Mailbox';");
		     out.println("</script>");   
		 } catch (MessagingException e) {
		     throw new RuntimeException(e);
		 }	
	}
}
