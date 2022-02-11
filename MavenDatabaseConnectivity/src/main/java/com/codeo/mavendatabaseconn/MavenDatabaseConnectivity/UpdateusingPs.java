package com.codeo.mavendatabaseconn.MavenDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateusingPs {

	public static void main(String[] args) {
		Scanner sc=null;
		String studentName=null;
	    String  studentmobileno=null;
	    String studentemailid=null;
	    Connection con=null;
	    PreparedStatement psmt=null;
	    
	    
	    int id=1;
	    String query="Update student_details set studentname=? ,studentmobileno=?,studentemailid=? Where student_id="+id;
	    int count=0;
	    String url="jdbc:mysql://localhost:3306/test";
	    String username="root";
	    String password="";
	    
	    try {
	    	sc=new Scanner(System.in);
	    	
		    //	sc=new Scanner(System.in);// created Object of Scanner class
		    	System.out.println("Enter studentName");
		    	studentName=sc.next();
		    	System.out.println("Enter StudentMobileNo");
		    	studentmobileno=sc.next();
		    	System.out.println("Enter StudentEmail id:");
		    	studentemailid=sc.next();
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
	    		System.out.println("Record Updated successfully");
	    	}
	    	else {
	    		System.out.println("Issue in record Updation");
	    	}
	    	
	    }
	    catch(ClassNotFoundException cnfe) {
	    	cnfe.printStackTrace();
	    }
	    catch(SQLException sqle) {
	    	sqle.printStackTrace();
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
