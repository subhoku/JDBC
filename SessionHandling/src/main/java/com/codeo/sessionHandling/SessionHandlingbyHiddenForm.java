package com.codeo.sessionHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/session1")
public class SessionHandlingbyHiddenForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int age=0;
		String name,lastname,mobileno,password,education,emailid;
		name=request.getParameter("name");
		lastname=request.getParameter("lastname");
		mobileno=request.getParameter("mobileno");
		emailid=request.getParameter("email");
		password=request.getParameter("password");
		education=request.getParameter("Education");
		age=Integer.parseInt(request.getParameter("age"));
		
		if(education.equals("12th")) {
			pw.println("<h1 style='color:orange;'>Registration form for 12th std</h1>");
	    	pw.println("<form action='secondurl' method='post'>");
	    	
	    	pw.println("Percentage in 12th std: <input type='text' name='percent1'><br>");
	    	pw.println("Percentage in 10th std: <input type='text' name='percent2'><br>");
	    	pw.println("<input type='hidden' name='s1name' value="+name+"><br>");
	    	pw.println("<input type='hidden' name='s1lastname' value="+lastname+" ><br>");
	    	pw.println("<input type='hidden' name='s1mobileno' value="+mobileno+"><br>");
	    	pw.println("<input type='hidden' name='s1email' value="+emailid+"><br>");
	    	pw.println("<input type='hidden' name='s1password'value="+password+"><br>");
	    	pw.println("<input type='hidden' name='s1age'value="+age+"><br>");
	    	pw.println("<input type='hidden' value="+education+" name='s1education'><br>");
	    	

	       	pw.println("<input type='submit' value='submit'></form>");
		}
		else if(education.equals("Poly")) {
			pw.println("<h1 style='color:orange;'>Registration form for Polytechnic </h1>");
	    	pw.println("<form action='secondurl' method='post'>");
	    	
	    	pw.println("Percentage in Poly: <input type='text' name='percent1'><br>");
	    	pw.println("Percentage in 10th std: <input type='text' name='percent2'><br>");
	    	pw.println(" <input type='hidden' name='s1name' value="+name+"><br>");
	    	pw.println("<input type='hidden' name='s1lastname' value="+lastname+" ><br>");
	    	pw.println(" <input type='hidden' name='s1mobileno' value="+mobileno+"><br>");
	    	pw.println(" <input type='hidden' name='s1email' value="+emailid+"><br>");
	    	pw.println(" <input type='hidden' name='s1password'value="+password+"><br>");
	    	pw.println(" <input type='hidden' name='s1age'value="+age+"><br>");
	    	pw.println(" <input type='hidden' value="+education+" name='s1education'><br>");
	    	

	       	pw.println("<input type='submit' value='submit'></form>");
	
		}
		else {
			pw.println("Enter Proper Input");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
