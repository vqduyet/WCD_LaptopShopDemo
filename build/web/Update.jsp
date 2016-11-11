<%-- 
    Document   : Update
    Created on : Nov 9, 2016, 11:52:11 PM
    Author     : Duyet
--%>

<%@page import="model.Laptop"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <div class="container">
            <h1>Update Item</h1>
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
            <form action="updateServlet" method="post" class="col-md-3">
                <div class="form-group">
                    <label for="lapId">Laptop ID</label>
                    <input type="text"
                           readonly="true"
                           id="lapId"
                           name="lapId"
                           class="form-control"
                           value="<%=request.getAttribute("editLap") == null ? "" : request.getAttribute("editLapId")%>"
                           />
                </div>
                <div class="form-group">
                    <label for="lapName">Laptop Name</label>
                    <input type="text"
                           id="lapName"
                           name="lapName"
                           class="form-control"
                           reqrequired="true"
                           value="<%=request.getAttribute("editLap") == null ? "" : request.getAttribute("editLapName")%>"
                           />
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number"
                           id="price"
                           name="price"
                           class="form-control"
                           required="true"
                           value="<%=request.getAttribute("editLap") == null ? "" : request.getAttribute("editPrice")%>"
                           />                
                </div>
                <input type="reset" value="Undo" class="btn btn-default"/> 
                <input type="submit" value="Update" class="btn btn-primary"/> 
                <a href="showServlet"><input type="button" value="Back to List" class="btn btn-info"/></a>
            </form>
        </div>
    </body>
</html>
