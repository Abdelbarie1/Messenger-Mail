package com.mail.presentation;

import java.io.IOException;



import com.mail.dao.UserMaildao;

import com.mail.functions.IUserMail;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




/**
 * Servlet implementation class Login
 */


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
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

		String mail=request.getParameter("email");
		String password= request.getParameter("pwd");	
		IUserMail user=new UserMaildao();
		if(user.login(mail,IUserMail.getsh(password))) {
			session.setAttribute("email",mail);
			session.setAttribute("pwd",password);
			response.sendRedirect("Mailbox");
		}
		else {
			response.sendRedirect("Login.jsp");

		}	
	}

}
