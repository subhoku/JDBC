package com.codeo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertionOperation {

	public static void main(String[] args) {
		
		//1.Register the Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.Establish the Connection: Between Database and software
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query="insert into login(email, password) values('sudarshan','xyz')";
		//3. Create a Statement
		Statement st=null;
		try {
			//4. Execute the Query
			st=con.createStatement();
			st.executeUpdate(query);
			st.close();
			con.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
