package com.codeo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2 Objects: 1.Request Object, 2. Response Object
		PrintWriter pw=null;
		pw=response.getWriter();
		String username=null;
		String password=null;
		 username=request.getParameter("pname");
		 password=request.getParameter("pass");
		 System.out.println("Username"+username+" Password:"+password);
		if(username.equals("Aakash") && password.equals("admin")) {
			pw.println("<body><h1 style='color: green;'>Welcome to your account Mr. "+username+"</h1>");
		}
		else {
			pw.println("<h3 style='color: red;'>Incorrect Credentials...</h3></body>");
		}
		
	}

}
