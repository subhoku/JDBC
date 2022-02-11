package com.codeo.mavendatabaseconn.MavenDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

public class MavenPreparedStatement {

	public static void main(String[] args) {
		Scanner sc=null;
		String studentName=null;
	    String  studentmobileno=null;
	    String studentemailid=null;
	    Connection con=null;
	    PreparedStatement psmt=null;
	    String query="insert into student_details(studentname, studentmobileno, studentemailid)" + "values(?,?,?)";
	    int count=0;
	    String url="jdbc:mysql://localhost:3306/test";
	    String username="root";
	    String password="";
	   
		//1. Register JDBC Driver type 4
    	//for Mysql
	    try {
	    	sc=new Scanner(System.in);
	    //	sc=new Scanner(System.in);// created Object of Scanner class
	    	System.out.println("Enter studentName");
	    	studentName=sc.next();
	    	System.out.println("Enter StudentMobileNo");
	    	studentmobileno=sc.next();
	    	System.out.println("Enter StudentEmail id:");
	    	studentemailid=sc.next();
	    	//1. Register JDBC Driver type 4
	    	//for Mysql
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con=DriverManager.getConnection(url,username,password);
    	if(con!=null) {
    	psmt=con.prepareStatement(query);
    	}
    	if(psmt!=null) {
    		psmt.setString(1, studentName);
    		psmt.setString(2, studentmobileno);
    		psmt.setString(3, studentemailid);
    	
    	}
    	count=psmt.executeUpdate();
    	if(count!=0) {
    		System.out.println("Record Inserted successfully");
    	}
    	else {
    		System.out.println("Issue in record Insertion");
    	}
	    }
	    catch(SQLException sqle) {
	    	sqle.printStackTrace();
	    }
	    catch(ClassNotFoundException cnfe) {
	    	cnfe.printStackTrace();
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


	}

}
