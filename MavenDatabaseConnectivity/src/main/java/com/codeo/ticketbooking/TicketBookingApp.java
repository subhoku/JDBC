package com.codeo.ticketbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TicketBookingApp {
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		String moviename;
		String name=null;
		String age=null;
		double movierate=0;
		int[] result;
		int viewers=0;
		String seatno="3";
		sc=new Scanner(System.in);
		if(sc!=null) 
			System.out.println("Enter MovieName: ");
			moviename=sc.next();
			
			System.out.println("Enter No of Viewers ");
			viewers=sc.nextInt();
			
		
		//1. Register JDBC Driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//2. Establish the connection with d/b
				
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//3. Create PreparedStatement obj
				String query="insert into cinemax(viewername, viewerage, seatno, moviename, movierate) values(?,?,?,?,?)";
				if(con!=null) {
					try {
						ps=con.prepareStatement(query);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i=0;i<viewers;i++) {
					System.out.println("Enter Person name: ");
					name=sc.next();
					System.out.println("Enter Person Age: ");
					age=sc.next();
					//add multiple parameters using query 
					try {
						ps.setString(1, name);
						ps.setString(2, age);
						ps.setString(3, seatno);
						ps.setString(4, moviename);
						if(moviename.equals("Spiderman"))
						{
							movierate=500.34;
							ps.setDouble(5, movierate);
						}
						else if(moviename.equals("Pushpa")) {
							movierate=200.34;
							ps.setDouble(5, movierate);
						}
						else {
							ps.setDouble(5, movierate);
						}
						
						ps.addBatch();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//execute the query
					if(ps!=null) {
						
						try {
							result=ps.executeBatch();
							if(result!=null) {
								System.out.println("GroupBooking done succefully");
							}
							else {
								System.out.println("Failure in group booking");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}

	}
	

	

}
