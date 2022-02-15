package com.codeo.imageinsert;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.compress.utils.IOUtils;

public class ImageRetrival {

	public static void main(String[] args) {
		int id=0;
		Scanner sc=null;
		String studentName=null;
	    String  studentLastname=null;
	    String studentAge=null;
	    String studentGender=null;
	    String imagepath=null;
	    Connection con=null;
	    PreparedStatement psmt=null;
	    ResultSet rs=null;
	    String query=null;
	    InputStream is=null;
	    OutputStream os=null;
	    try {
	    	sc=new Scanner(System.in);
	    	if(sc!=null) {
	    		System.out.println("Enter Student id: ");
	    		id=sc.nextInt();
	    	}
	    	//Register Jdbc Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection with database s/w and app
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imageref","root","");
	    	//Write a query
			query="select * from imageupload where id=?";
			//Create PreparedStatement
			if(con!=null) {
				psmt=con.prepareStatement(query);
			}
			//set values of query parameter
			if(psmt!=null) {
				psmt.setInt(1, id);
			}
			//send and execute query
			if(psmt!=null) {
				rs=psmt.executeQuery();
			}
			//process the resultSet Object
			if(rs!=null) {
				while(rs.next()) {
				id=rs.getInt(1);
				studentName=rs.getString(2);
				studentLastname=rs.getString(3);
				studentAge=rs.getString(4);
				studentGender=rs.getString(5);
				is=rs.getBinaryStream(6);
				System.out.println(is);
				System.out.println(id+" "+studentName+" "+studentLastname+" "+studentGender+" "+studentAge);
				//Write a Blob value with Destination path
				os=new FileOutputStream("F:\\Java Development\\GetFolder\\sud.png");
				IOUtils.copy(is,os);
				}//while
	    }//if
			System.out.println("ImageRetrieved and stored in location");
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
	    

	}

}
