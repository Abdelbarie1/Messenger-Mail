package com.mail.presentation;

import java.io.IOException;


import java.io.PrintWriter;


import com.mail.dao.UserMaildao;
import com.mail.functions.IUserMail;
import com.mail.module.UserMail;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SignIn
 */

public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
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
		//HttpSession session = request.getSession();
		IUserMail user=new UserMaildao();
		response.setContentType("text/html");
		String firstname=request.getParameter("firstName");
		String lastname= request.getParameter("lastname");
		String mail=request.getParameter("email");
		String password1= request.getParameter("pwd");
		String password2= request.getParameter("pwd2");		
		if(user.isexiste(mail)) {
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Mail utilisable');");
            out.println("window.location.href = 'SingIn.jsp';");
            out.println("</script>");
		}		
		else {
			if(password1.equals(password2)){
				password1=IUserMail.getsh(password1);
				UserMail usermail=new UserMail(firstname,lastname,mail,password1);
				user.register(usermail);
				response.sendRedirect("Login.jsp");
			}
			else {
				PrintWriter out = response.getWriter() ;
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Password non Identique');");
				out.println("window.location.href = 'SingIn.jsp';");
				out.println("</script>");		
			}
		}
	}
}
