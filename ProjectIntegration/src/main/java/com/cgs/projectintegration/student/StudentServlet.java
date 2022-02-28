package com.cgs.projectintegration.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertData")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentDao sdao=null;
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
    	
    	try {
    		PrintWriter pw=null;
			pw=response.getWriter();
			String username,password,email;
			username=request.getParameter("username");
			password=request.getParameter("password");
			email=request.getParameter("email");
			sdao=new StudentDao();
			sdao.insertParameters(username,password,email);
		}
    	
    	
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		
	    		try {
					getServletContext().getRequestDispatcher("/studentform.jsp")
					.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
    	}
	}


