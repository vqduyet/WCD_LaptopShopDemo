<%-- 
    Document   : Show
    Created on : Nov 9, 2016, 8:29:49 PM
    Author     : Duyet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show</title>
        
        <script>
            //handle search radio
            $(document).ready(function() {
                $(function() {
                    var $radios = $('input:radio[name=radioSearch]');
                    var $radVal = '<%=request.getAttribute("radValue")%>';
                    if ($radVal === 'null') {
                        $radios.filter('[value=searchPrice]').prop('checked', true);
                        priceSearchSector();
                    }
                    else if ($radVal === "searchPrice") {
                        $radios.filter('[value=searchPrice]').prop('checked', true);
                        priceSearchSector();
                    }
                    else if ($radVal === "searchName") {
                        $radios.filter('[value=searchName]').prop('checked', true);
                        nameSearchSector();
                    }

                });

                $('input:radio').click(function() {
                    var radVal = $(this).val();
                    if (radVal === "searchPrice") {
                        priceSearchSector();
                    }
                    else {
                        nameSearchSector();
                    }
                });
            });

            function priceSearchSector() {
                $("#formsearchPrice").prop("hidden", false);
                $("#formsearchName").prop("hidden", true);                
            }
            function nameSearchSector() {
                $("#formsearchPrice").prop("hidden", true);
                $("#formsearchName").prop("hidden", false);
                $("#min").val("");
                $("#max").val("");
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <h1>List of Laptop</h1>
            <!--error-->
            <% if (request.getAttribute("err") != null) {%>
            <div class="row">
                <p class="alert-warning col-md-4">Error: <%=request.getAttribute("err")%></p>
            </div>            
            <% }%>
            <!--end of error-->

            <!--search-->
            <form action="searchServlet" method="post" class="col-md-2">
                <!-- search radios -->
                <div class="form-group">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="radioSearch" id="searchPrice" value="searchPrice">
                            Search by Price
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="radioSearch" id="searchName" value="searchName">
                            Search by Name
                        </label>
                    </div>
                </div>
                <!-- end of search radios -->
                <!-- fieldset set by price-->
                <fieldset id="formsearchPrice">
                    <legend>Search by Price</legend>
                    <div class="form-group">
                        <label class="control-label" for="min">Min Price</label>
                        <input type="number" id="min" name="min" class="form-control"/>                
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="max">Max Price</label>
                        <input type="number" id="max" name="max" class="form-control"/>                
                    </div>
                </fieldset>
                <!-- end of fieldset set by price-->
                <!-- fieldset set by name-->
                <fieldset id="formsearchName" hidden="">
                    <legend>Search by Name</legend>
                    <div class="form-group">
                        <label class="control-label" for="sName">Laptop Name</label>
                        <input type="text" id="sName" name="sName" class="form-control"/>                
                    </div>
                </fieldset>
                <!-- end of fieldset set by price-->
                <input type="submit" value="Search" class="btn btn-default"/>
            </form>
            <!--end of search-->

            <!--list-->
            <div class=" col-md-offset-1 col-md-6">
                <table class="table table-bordered">
                    <tr>
                        <th>Laptop ID</th>
                        <th>Laptop Name</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${list}" var="l">
                        <tr>
                            <td>${l.lapID}</td>
                            <td>${l.lapName}</td>
                            <td>${l.price}</td>
                            <td><a href="deleteServlet?id=${l.lapID}">Delete</a> | 
                                <a href="updateServlet?id=${l.lapID}">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <!--end of list-->
        </div>
    </body>
</html>
