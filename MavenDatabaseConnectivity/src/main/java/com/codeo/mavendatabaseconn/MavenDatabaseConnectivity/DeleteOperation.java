package com.codeo.mavendatabaseconn.MavenDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOperation {

	public static void main(String[] args) {
		Scanner sc=null;
		int id=0;
	    Connection con=null;
	    Statement st=null;
	    String query=null;
	    int count=0;
	    try {
	    	sc=new Scanner(System.in);
	    	System.out.println("Enter record to be deleted");
	    	id=sc.nextInt();
	    	//Register the Driver
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	//Establish the connection
	    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	    	query="delete from student_details where student_id="+id;
	    	if(con!=null) {
	    		st=con.createStatement();
	    	}
	    	//Send and execute the SQl Query
	    	if(st!=null) {
	    		count=st.executeUpdate(query);
	    	}
	    	if(count==0) {
	    		System.out.println("Issue in delete query");
	    	}
	    	else {
	    		System.out.println("Record delete sucessfully for: "+id+" candidate");
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
	    		if(st!=null) {
	    			st.close();
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