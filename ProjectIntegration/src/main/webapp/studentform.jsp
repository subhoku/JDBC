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
    <link rel="stylesheet" href="vendors/jqvmap/dist/jqvmap.min.css">


    <link rel="stylesheet" href="assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

</head>



<body>
<%@include file="asidebar.jsp" %>
    <div id="right-panel" class="right-panel">
<%@include file="adminheader.jsp" %>
<div class="col-lg-6">
                                                    <div class="card">
                                                        <div class="card-header">Example Form</div>
                                                        <div class="card-body card-block">
                                                            <form action="insertData" method="post" >
                                                                <div class="form-group">
                                                                    <div class="input-group">
                                                                        <div class="input-group-addon"><i class="fa fa-user"></i></div>
                                                                        <input type="text" id="username" name="username" placeholder="Username" class="form-control">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="input-group">
                                                                        <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                                                        <input type="email" id="email" name="email" placeholder="Email" class="form-control">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="input-group">
                                                                        <div class="input-group-addon"><i class="fa fa-asterisk"></i></div>
                                                                        <input type="password" id="password" name="password" placeholder="Password" class="form-control">
                                                                    </div>
                                                                </div>
                                                                <div class="form-actions form-group"><button type="submit" class="btn btn-success btn-sm">Submit</button></div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>





                            <script src="vendors/jquery/dist/jquery.min.js"></script>
                            <script src="vendors/popper.js/dist/umd/popper.min.js"></script>

                            <script src="vendors/jquery-validation/dist/jquery.validate.min.js"></script>
                            <script src="vendors/jquery-validation-unobtrusive/dist/jquery.validate.unobtrusive.min.js"></script>

                            <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
                            <script src="assets/js/main.js"></script>
</div></body>



</html>