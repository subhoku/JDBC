package com.codeo.mavendatabaseconn.MavenDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrivalusingMysql {
	
	
	public static void main(String[] arg) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//Register the Jdbc Driver Type 4 Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establish the conn....
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			//Write a query.
			String query="select * from student_details";
			//Create a statement
			if(con!=null) {
				st=con.createStatement();
			}
			//send and execute the query in database software
			if(st!=null) {
				rs=st.executeQuery(query);
			}
			//process the resultSet Object
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4));
				}
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
