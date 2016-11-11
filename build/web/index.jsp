<%-- 
    Document   : index
    Created on : Nov 9, 2016, 8:03:29 PM
    Author     : Duyet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div class="container">
            <h1>Insert New Laptop</h1>
            <!--error-->
            <div class="row">
                <div class="col-md-5">
                    <% if (request.getAttribute("err") != null) {%>
                    <p class="alert-warning"><%=request.getAttribute("err")%></p>
                    <% }%>
                    <% if (request.getAttribute("err1") != null) {%>
                    <p class="alert-warning"><%=request.getAttribute("err1")%></p>
                    <% }%>
                </div>
            </div>
            <!--end of error-->
            <form action="insertServlet" method="post" class="col-md-3">
                <div class="form-group">
                    <label for="lapId">Laptop ID</label>
                    <input type="text"
                           id="lapId"
                           name="lapId"
                           class="form-control"
                           required="true"
                           value="<%=request.getAttribute("errLapId") == null ? "" : request.getAttribute("errLapId")%>"
                           />
                </div>
                <div class="form-group">
                    <label for="lapName">Laptop Name</label>
                    <input type="text"
                           id="lapName"
                           name="lapName"
                           class="form-control"
                           required="true"
                           value="<%=request.getAttribute("errLapName") == null ? "" : request.getAttribute("errLapName")%>"
                           />
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number"
                           id="price"
                           name="price"
                           class="form-control"
                           required="true"
                           value="<%=request.getAttribute("errPrice") == null ? "" : request.getAttribute("errPrice")%>"
                           />                
                </div>
                <input type="submit" value="Insert" class="btn btn-primary"/> 
                <input type="reset" value="Reset" class="btn btn-default"/>
            </form>
        </div>

    </body>
</html>
