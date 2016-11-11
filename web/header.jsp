<%-- 
    Document   : header
    Created on : Nov 9, 2016, 10:48:09 PM
    Author     : Duyet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>        

        <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.css"/>
        <script type="text/javascript" src="./resources/jquery/jquery.js"></script>
        <script type="text/javascript" src="./resources/bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <!--menu-->
        <nav id="nav_bar" class="navbar navbar-inverse">
            <div class="container-fluid">                
                <div class="navbar-header">
                    <!--icon for collapsed menu items-->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--logo -->
                    <a href="index.jsp" class="navbar-brand">LAPTOP WORLD</a>
                </div>                
                <!--menu items -->
                <div class="collapse navbar-collapse" id="mainNavBar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="showServlet">List</a></li>                        
                    </ul>

                    <!-- right align -->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Logout</a></li>   
                    </ul>
                </div>
            </div>
        </nav>
        <!--end of menu-->
    </body>
</html>
