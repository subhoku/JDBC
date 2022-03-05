<%@page import="java.sql.*"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";



try {
	//Register the Driver
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>



<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sufee Admin - HTML5 Admin Template</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">


    <link rel="stylesheet" href="vendors/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendors/themify-icons/css/themify-icons.css">
    <link rel="stylesheet" href="vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="vendors/selectFX/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="vendors/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="vendors/datatables.net-buttons-bs4/css/buttons.bootstrap4.min.css">

    <link rel="stylesheet" href="assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

</head>

<body>
<%@include file="asidebar.jsp" %>
 <div id="right-panel" class="right-panel" style="background-image: url('sidd.png'); width: -150px;height: -50px" >
<%@include file="adminheader.jsp" %>
<div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Data Table</strong>
                            </div>
                            <div class="card-body" id="myfrm">
                           <div class="row"><div class="col-sm-12">
                         <input type="button" class="btn btn-success" style="border-radius:30px;" onclick="myPrint('myfrm')" value="print">
                       <input type="button" class="btn btn-success" value="Download Excel File" onclick="exportToExcel('bootstrap-data-table-export')" style="margin-left:600px; margin-bottom:20px;border-radius:30px" />
                       <script src="exportToExcel.js" defer></script>    
                           
                           <table id="bootstrap-data-table-export" class="table table-striped table-bordered dataTable no-footer" role="grid" aria-describedby="bootstrap-data-table-export_info">
                                    <thead>
                                        <tr role="row">
                                          <th class="sorting_asc" tabindex="0" aria-controls="bootstrap-data-table-export" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 210px;">Sr<br>No</th>
                                        <th class="sorting_asc" tabindex="0" aria-controls="bootstrap-data-table-export" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 210px;">username</th>
                                        <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table-export" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 349px;">Password</th>
                                        <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table-export" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 154px;">Email Id</th>
                                        <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table-export" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending" style="width: 121px;">Date:Time</th>
                                        <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table-export" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 154px;">Edit</th>
                                        <th class="sorting" tabindex="0" aria-controls="bootstrap-data-table-export" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending" style="width: 121px;">Delete</th>
                                              
                                      
                                        </tr>
                                    </thead>
                                    <%
                                    //Establish connection with database
                                    try{
                                    	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                                    
                                    statement=connection.createStatement();
                                    String query="select * from student_1";
                                    resultSet=statement.executeQuery(query);
                                    
                                    while(resultSet.next()){
                                    	%>
                                <!--     	id, username, password, email, dtime -->
                                   <tr>
                                   <td><%=resultSet.getString("id") %></td>
                                    <td><%=resultSet.getString("username") %></td>
                                    <td><%=resultSet.getString("password") %></td>
                                    <td><%=resultSet.getString("email") %></td>
                                    <td><%=resultSet.getString("dtime") %></td>
                                   
                                   <td><a href="edit.jsp?id=<%=resultSet.getString("id") %>"><i class="fa fa-edit"></i></a></td>
                                   <td><a href="delete.jsp?id=<%=resultSet.getString("id") %>"><i class="fa fa-trash-o"></i></a></td>
                                   </tr>
                                   
                                   <%} 
                                   resultSet.close();
                                   statement.close();
                                   connection.close();
                                    }
                                   catch(Exception e){
                                	   e.printStackTrace();
                                   }
                                   %> 
                                    
                                    <tbody>
                           
                                    </tbody>
                                </table></div></div>
                            </div>
                        </div>
                    </div>


                </div>
            </div><!-- .animated -->
        </div>

</div>

    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <script src="vendors/popper.js/dist/umd/popper.min.js"></script>
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>


    <script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="vendors/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="vendors/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js"></script>
    <script src="vendors/jszip/dist/jszip.min.js"></script>
    <script src="vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="vendors/pdfmake/build/vfs_fonts.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="vendors/datatables.net-buttons/js/buttons.colVis.min.js"></script>
    <script src="assets/js/init-scripts/data-table/datatables-init.js"></script>
<script>
        function myPrint(myfrm) {
            var printdata = document.getElementById(myfrm);
            newwin = window.open("");
            newwin.document.write(printdata.outerHTML);
            newwin.print();
            newwin.close();
        }
    </script>
</body>


</html>