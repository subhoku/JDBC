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
		
		int age=0;
		 username=request.getParameter("pname");
		 password=request.getParameter("pass");
		 age=Integer.parseInt(request.getParameter("page"));
		/*
		 * tage=request.getParameter("page"); age=Integer.parseInt(tage);
		 */
		 System.out.println("Username"+username+" Password:"+password);
		if(age>=18) {
			pw.println("<h1 style='color: green;'>You are eligible for vote Mr. "+username+"</h1>");
		}
		else {
			pw.println("<h3 style='color: red;'>Whenever your age will be 18+you can Vote"+"</h3>");
		}
		
	}

}
