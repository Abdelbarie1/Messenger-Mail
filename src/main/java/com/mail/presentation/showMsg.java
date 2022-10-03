package com.mail.presentation;

import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.mail.module.Alias;

/**
 * Servlet implementation class showMsg
 */
public class showMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showMsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email="";
	    String pwd="";
	    HttpSession session = request.getSession();
	    if (session.getAttribute("email") != null){
	    	email = session.getAttribute("email").toString();
		   	pwd = session.getAttribute("pwd").toString();
	 	}else{
			response.sendRedirect("Login.jsp");
    	}
		int num= Integer.parseInt(request.getParameter("id"));		
		request.setAttribute("idd", num);
		request.setAttribute("emailMessages", Alias.getEmailmsgs());
		request.setAttribute("email",email);
	    request.setAttribute("pwd",pwd);
		this.getServletContext().getRequestDispatcher("/showMsg.jsp").forward(request, response);
	}
	
	/**
	 *@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
	}
		
		

}
