package com.codeo.mavendatabaseconn.MavenDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//Best Practices
public class DataInsert {

	public static void main(String[] args) {
	Scanner sc=null;
	String studentName=null;
    String  studentmobileno=null;
    String studentemailid=null;
    Connection con=null;
    Statement st=null;
    String query=null;
    int count=0;
    try {
    	sc=new Scanner(System.in);// created Object of Scanner class
    	System.out.println("Enter studentName");
    	studentName=sc.next();
    	System.out.println("Enter StudentMobileNo");
    	studentmobileno=sc.next();
    	System.out.println("Enter StudentEmail id:");
    	studentemailid=sc.next();
    	//1. Register JDBC Driver type 4
    	//for Mysql
    	Class.forName("com.mysql.jdbc.Driver");
    	//for Oracle
    	//Class.forName("oracle.jdbc.driver.OracleDriver");
    	//for PostGreSQL Database
    	//   Class.forName("org.postgresql.Driver");
    	//2. Establish the connection between app and database software
    //	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe/test","system","manager");
    	// con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "Subho");
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    	//Write the query
    	//st.executeUpdate("INSERT into family(name, mobile)" +"values('"+name+"', '"+num+"')");
    	query="insert into student_details(studentname, studentmobileno, studentemailid)" + "values('"+studentName+"','"+studentmobileno+"','"+studentemailid+"')";
    	if(con!=null)
    		st=con.createStatement();
    	
    	//Send and execute the SQl Query
    	if(st!=null) {
    		count=st.executeUpdate(query);
    		System.out.println(count);
    		    	}
    	//Process the result
    	if(count==0) {
    		System.out.println("Issues in record insertion");
    	}
    	else {
    System.out.println("Record Inserted Successfully");
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

	}//main Method

}//class
