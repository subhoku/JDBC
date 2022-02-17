package com.codeo.ticketbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		int result[]=null;
		int sum=0;
         try {
        	 //register JDBC driver s/w
        	 Class.forName("com.mysql.cj.jdbc.Driver");
        	 //establish the connection
        	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj1111db","root","");
        	 //create Statement object
        	 if(con!=null)
        		 st=con.createStatement();
        	 //add Queries to the batch
        	 if(st!=null) {
        		 String insertquery="INSERT INTO person_tab(person) VALUES('sudarshan')";
        		 st.addBatch(insertquery);
        		 st.addBatch("UPDATE person_tab SET person='Nagendra' WHERE pid=2");
        		 st.addBatch("DELETE FROM person_tab WHERE pid=3");
        	 }
        	 //execute the batch
        	 if(st!=null) {
        		 result=st.executeBatch();
        	 }
        	 //process the Result
        	 for(int i=0;i<result.length;++i) {
        		 sum=sum+result[i];
        	 }
        	 
        	 System.out.println("No.of record that effected::"+sum);
        	 
        	 
         }//try
         catch(SQLException se) {
        	 se.printStackTrace();
         }
         catch(ClassNotFoundException cnf) {
        	 cnf.printStackTrace();
         }
         catch(Exception e) {
        	 e.printStackTrace();
         }
         finally {
        	 //close jdbc objs
        	 try {
        		 if(st!=null)
        			 st.close();
        	 }
        	 catch(SQLException se) {
        		 se.printStackTrace();
        	 }
        	 try {
        		 if(con!=null)
        			 con.close();
        	 }
        	 catch(SQLException se) {
        		 se.printStackTrace();
        	 }
         }//finally
	}//main
}
