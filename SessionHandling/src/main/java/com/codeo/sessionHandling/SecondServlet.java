package com.codeo.sessionHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
		try {
			PrintWriter pw=response.getWriter();
			int age=0;
			//from 1st form
			String name,lastname,mobileno,password,education,emailid;
			//from 2nd form
			String percent1,percent2;
			//parameters from form 2 carried
			name=request.getParameter("s1name");
			lastname=request.getParameter("s1lastname");
			mobileno=request.getParameter("s1mobileno");
			emailid=request.getParameter("s1email");
			password=request.getParameter("s1password");
			education=request.getParameter("s1education");
			age=Integer.parseInt(request.getParameter("s1age"));

			// parameters from form 2 current
			percent1=request.getParameter("percent1");
			percent2=request.getParameter("percent2");
			pw.println("<h1 style='color:orange;'>Registration form for 3rd Stage</h1>");
	    	pw.println("<form action='thirdurl' method='post' enctype='multipart/form-data'>");
	    	
	    	pw.println("<input type='hidden' name='percent11' value="+percent1+"><br>");
	    	pw.println("<input type='hidden' name='percent12' value="+percent2+"><br>");
	    	pw.println("<input type='hidden' name='s2name' value="+name+"><br>");
	    	pw.println("<input type='hidden' name='s2lastname' value="+lastname+" ><br>");
	    	pw.println("<input type='hidden' name='s2mobileno' value="+mobileno+"><br>");
	    	pw.println("<input type='hidden' name='s2email' value="+emailid+"><br>");
	    	pw.println("<input type='hidden' name='s2password'value="+password+"><br>");
	    	pw.println("<input type='hidden' name='s2age'value="+age+"><br>");
	    	pw.println("<input type='hidden' value="+education+" name='s2education'><br>");
	    	pw.println("Submit Resume: <input type='file'  name='resume'><br>");
	    	pw.println("Submit Image: <input type='file'  name='photo'><br>");
	       	pw.println("<input type='submit' value='submit'></form>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	
}
