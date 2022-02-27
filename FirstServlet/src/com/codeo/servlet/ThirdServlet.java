package com.codeo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		String name,lastname,email,course,gender,hobbies,degree,address,date;
	int age=0;
		name=request.getParameter("name");
		lastname=request.getParameter("lastname");
		age=Integer.parseInt(request.getParameter("age"));
		gender=request.getParameter("gender");
		hobbies=request.getParameter("hobbies");
		pw.println("<body><h2>"+name+"</h2>");
		pw.println("<h2>"+lastname+"</h2>");
		pw.println("<h2>"+age+"</h2>");
		pw.println("<h2>"+gender+"</h2>");
		pw.println("<h2>"+hobbies+"</h2></body>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
