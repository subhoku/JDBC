package com.codeo.ticketbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class GroupTicketBooking {
	//Group Ticket Booking Reservation Task No of passenger
		public static void main(String[] args) {
			Scanner sc=null;
			Connection con=null;
			PreparedStatement ps=null;
			String source, destination;
			String name=null;
			String gender=null;
			int[] result;
			int passengers=0;
			String seatno="3";
			sc=new Scanner(System.in);
			if(sc!=null) 
				System.out.println("Enter Source station: ");
				source=sc.next();
				System.out.println("Enter Destination Station: ");
				destination=sc.next();
				System.out.println("Enter No of passengers: ");
				passengers=sc.nextInt();
				
			
			//1. Register JDBC Driver
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//2. Establish the connection with d/b
					
					try {
						
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//3. Create PreparedStatement obj
					String query="insert into ticket_reservation(passengername, gender, seatno, startingpoint, destination) values(?,?,?,?,?)";
					if(con!=null) {
						try {
							ps=con.prepareStatement(query);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for(int i=0;i<passengers;i++) {
						System.out.println("Enter Person name: ");
						name=sc.next();
						System.out.println("Enter Person Gender: ");
						gender=sc.next();
						//add multiple parameters using query 
						try {
							ps.setString(1, name);
							ps.setString(2, gender);
							ps.setString(3, seatno);
							ps.setString(4, source);
							ps.setString(5, destination);
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
