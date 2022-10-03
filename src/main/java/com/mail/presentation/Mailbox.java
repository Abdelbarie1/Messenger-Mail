package com.mail.presentation;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import com.mail.module.Alias;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Servlet implementation class Mailbox
 */
@WebServlet("/mailbox")

public class Mailbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mailbox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String pop3Host="192.168.239.147";
		//String from = request.getParameter("from1");
     //   String pwd = request.getParameter("pwd1");
        String email="";
	    String pwd="";
	    HttpSession session = request.getSession();
	    if (session.getAttribute("email") != null){
	    	email = session.getAttribute("email").toString();
	    	pwd = session.getAttribute("pwd").toString();
	    }else{
	    	response.sendRedirect("Login.jsp");
	    }
        System.out.println(request.getParameter("mail"));
		Properties props = new Properties();
		props.put("mail.pop3.host", pop3Host);
		props.put("mail.pop3.port", "110");
		props.put("mail.pop3.starttls.enable", "true");
		props.put("mail.store.protocol", "pop3");
		Session session2 = Session.getInstance(props);	
	try {  
		String storeType = "pop3";
		Store mailStore = session2.getStore(storeType);
		mailStore.connect(pop3Host, email, pwd);
		Folder folder = mailStore.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		Message[] emailMessages = folder.getMessages();
		Alias.setEmailmsgs(emailMessages);
	    request.setAttribute("emailMessages",Alias.getEmailmsgs());
	    request.setAttribute("email",email);
	    request.setAttribute("pwd",pwd);
		this.getServletContext().getRequestDispatcher("/mailbox.jsp").forward(request, response);
		System.out.println("Total Message - " 
				+ emailMessages.length);
		String date=request.getParameter("date");
		session.setAttribute("date",date);
	} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in receiving email.");
	} 
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		}
	

}
