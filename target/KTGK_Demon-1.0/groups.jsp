<%-- 
    Document   : groups
    Created on : Apr 5, 2024, 4:44:09 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.ktgk_demon.models.Group"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ktgk_demon.database.DBConnect"%>
<%@page import="com.mycompany.ktgk_demon.implement.GroupsServiceImplement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "css.jsp" %>
    </head>
    <body>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Group Name</th>
                    <th scope="col">Description</th>
                </tr>
            </thead>
            <tbody>
                <%
                    GroupsServiceImplement gs = new GroupsServiceImplement(DBConnect.getConnection());
                    List<Group> groupList = gs.getGroup();
                    int id = 1;
                    for (Group group : groupList) {
                    %><tr>
                        <td><%=id%></td>
                        <td><%=group.getGroupName()%></td>
                        <td><%=group.getDesription()%></td>
                    </tr>
                    <%
                        id++;
                    } 
                %>
            </tbody>
        </table>
        <a href="add_group.jsp">Add Group</a>
    </body>
</html>
