package com.codeo.sessionHandling;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/thirdurl")
@MultipartConfig(maxFileSize = 16177215) 
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int age=0;
		String name,lastname,mobileno,password,education,emailid;
		//from 2nd form
		String percent1,percent2;
		//parameters from form 2 carried
		name=request.getParameter("s2name");
		lastname=request.getParameter("s2lastname");
		mobileno=request.getParameter("s2mobileno");
		emailid=request.getParameter("s2email");
		password=request.getParameter("s2password");
		education=request.getParameter("s2education");
		age=Integer.parseInt(request.getParameter("s2age"));
		// parameters from form 2 current
		percent1=request.getParameter("percent11");
		percent2=request.getParameter("percent12");
		InputStream inputStream = null; // input stream of the upload file

		String message = null;
		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}
		System.out.println(name+" "+lastname+" "+mobileno+" "+emailid+" "+password+" "+education+" "+age+" "+percent1+" "+percent2+" "+filePart.getName());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
