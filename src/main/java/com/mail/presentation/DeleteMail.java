package com.mail.presentation;

import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

/**
 * Servlet implementation class DeleteMail
 */
public class DeleteMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMail() {
        super();
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
		
		String email="";
	    String pwd="";
	    HttpSession session = request.getSession();
	if (session.getAttribute("email") != null){
		email = session.getAttribute("email").toString();
		pwd = session.getAttribute("pwd").toString();	
	}else{
		response.sendRedirect("Login.jsp");
	}
		String num= request.getParameter("id");
	    String pop3Host= "192.168.239.147";	  
		Properties props = new Properties();
		props.put("mail.pop3.host", pop3Host);
		Session session2 = Session.getInstance(props);
		try {
			 Store store = session2.getStore("pop3");
			 store.connect(pop3Host, email, pwd);
			 Folder folder = store.getFolder("INBOX");
			 folder.open(Folder.READ_WRITE);
		     Message[] emailMessages = folder.getMessages();    
		     String emailNo = num;
		     emailMessages[Integer.parseInt(emailNo) - 1].
		     setFlag(Flags.Flag.DELETED, true);	 
		     folder.close(true);	       
		     store.close();
		     response.setContentType("text/html");
		     PrintWriter out = response.getWriter() ;
		     out.println("<script type=\"text/javascript\">");
	         out.println("alert(' email deleted successfully....');");
	         out.println("window.location.href = 'Mailbox';");  
	         out.println("</script>");
		} catch (Exception e) {
		        e.printStackTrace();
		        System.err.println("Error in deleting email.");
		    }           
	}

}
