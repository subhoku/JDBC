<%@page import="java.sql.*"%>


<% 
String id=request.getParameter("id");
String username=request.getParameter("username");
String email=request.getParameter("email");
String password1=request.getParameter("password");
System.out.print(id+" "+username+" "+email+"  "+password1);

%>
<%

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "test";
String userid = "root";
String password = "";



Connection connection = null;
PreparedStatement ps = null;
ResultSet resultSet = null;
try {
	//register the driver
Class.forName(driver);
connection=DriverManager.getConnection(connectionUrl+database,userid,password);
String query="Update Student_1 set id=?,username=?,password=?, email=? where id="+id;
ps=connection.prepareStatement(query);

ps.setString(1,id);
ps.setString(2,username);
ps.setString(3,password1);
ps.setString(4,email);

int i=ps.executeUpdate();
if(i>0){
	System.out.println("Data Updated Successfully");
}
else{
	System.out.println("Issue in data updation");
}
} catch (Exception e) {
e.printStackTrace();
}
finally{
	response.sendRedirect("studentreports.jsp");
}
%>



