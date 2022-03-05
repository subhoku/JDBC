package com.cgs.projectintegration.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
			PrintWriter pw=response.getWriter();
			String username=null,password=null;
			username=request.getParameter("username");
			password=request.getParameter("password");
			
			if(username.equals("admin") && password.equals("admin")) {
				try {
					response.sendRedirect("studentreports.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					response.sendRedirect("login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}

}
