package com.codeo.imageinsert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ImageInsert {
	
	public static void main(String[] args) {
		Scanner sc=null;
		String studentName=null;
	    String  studentLastname=null;
	    String studentAge=null;
	    String studentGender=null;
	    String imagepath=null;
	    Connection con=null;
	    PreparedStatement psmt=null;
	    String query=null;
	    int count=0;
		sc=new Scanner(System.in);
		System.out.println("Enter Name: ");
		studentName=sc.next();
		System.out.println("Enter LastName: ");
		studentLastname=sc.next();
		System.out.println("Enter Age: ");
		studentAge=sc.next();
		System.out.println("Enter Gender: ");
		studentGender=sc.next();
		System.out.println("Enter ImagePath");
		imagepath=sc.next();
		//file Handling
		File f=new File(imagepath);
		System.out.println("File Length will be: "+f.length());
        
	//Create an inputStream for holding image path
		
		try {
			//FileReader fis=new FileReader(f);
			FileInputStream fis=new FileInputStream(f);
			//Register Jdbc Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection with database s/w and app
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imageref","root","");
			//Write and execute the query
		 query="insert into imageupload(name, lastname, gender, age, image) values(?,?,?,?,?)";
		 if(con!=null) {
			 psmt=con.prepareStatement(query); 
		 }
		 if(psmt!=null) {
			 psmt.setString(1, studentName);
			 psmt.setString(2, studentLastname);
			 psmt.setString(3, studentAge);
			 psmt.setString(4, studentGender);
			 psmt.setBlob(5, fis);
		 }
		 if(psmt!=null) {
			 count=psmt.executeUpdate();
		 }
		 if(count==0) {
			 System.out.println("Problem in Record Insertion");
		 }
		 else {
			 System.out.println("Record Inserted Successfully");
		 }
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch(Exception e) {
		    	e.printStackTrace();
		    	 }
		    finally {
		    	//close Jdbc Objects
		    	try {
		    		if(psmt!=null) {
		    			psmt.close();
		    		}
		    		if(con!=null) {
		    			con.close();
		    		}
		    	}
		    	catch(SQLException se) {
		    		se.printStackTrace();
		    	}
		    	
		    	
		    }//finally
		}//main

}//class
