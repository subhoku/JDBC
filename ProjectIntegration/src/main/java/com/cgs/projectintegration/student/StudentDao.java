package com.cgs.projectintegration.student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StudentDao {

	public void insertParameters(String username, String password, String email) {
		Connection con=null;
		
		
	    PreparedStatement psmt=null;
	    String query="insert into student_1(username, password, email)" + "values(?,?,?)";
	    int count=0;
	    String url="jdbc:mysql://localhost:3306/test";
	    String username1="root";
	    String password1="";
	   
		//1. Register JDBC Driver type 4
    	//for Mysql
	    try {
	    	
	    	
	    	//1. Register JDBC Driver type 4
	    	//for Mysql
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con=DriverManager.getConnection(url,username1,password1);
    	if(con!=null) {
    	psmt=con.prepareStatement(query);
    	}
    	if(psmt!=null) {
    		psmt.setString(1, username);
    		psmt.setString(2, password);
    		psmt.setString(3, email);
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
