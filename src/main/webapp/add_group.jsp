<%-- 
    Document   : add_group
    Created on : Apr 5, 2024, 8:07:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "css.jsp" %>;
    </head>
    <body>
        <form action="./add_group" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Name</label>
                <input type="String" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="group_name" required="required">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Desription</label>
                <input type="String" class="form-control" id="exampleInputPassword1" name="desription" required="required">
            </div>
            <div class="text-center mt-2">
                <button type="submit" class="btn btn-danger text-white">Add</button>
            </div>
        </form>
    </body>
</html>
