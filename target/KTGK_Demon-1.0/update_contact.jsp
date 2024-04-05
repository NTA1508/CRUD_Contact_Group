<%-- 
    Document   : add_contact
    Created on : Apr 5, 2024, 9:10:30 PM
    Author     : Admin
--%>

<%@page import="com.mycompany.ktgk_demon.models.Contacts"%>
<%@page import="com.mycompany.ktgk_demon.implement.ContactServiceImplement"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ktgk_demon.database.DBConnect"%>
<%@page import="com.mycompany.ktgk_demon.implement.GroupsServiceImplement"%>
<%@page import="com.mycompany.ktgk_demon.models.Group"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="css.jsp" %>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            ContactServiceImplement cs = new ContactServiceImplement(DBConnect.getConnection());
            Contacts contact = cs.getContactsByID(id);
        %>
        <form action="./update_contact" method="post">
            <input type="hidden" name = "id" value="<%=contact.getId()%>">
            <div class="form-group">
                <label for="exampleInputEmail1">First Name</label>
                <input type="String" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="firstName" required="required" value="<%=contact.getFirstName()%>">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Last Name</label>
                <input type="String" class="form-control" id="exampleInputPassword1" name="lastName" required="required" value="<%=contact.getLastName()%>">
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Group</label>
                <select class="form-control" id="exampleFormControlSelect1" name="groupId" required="required">
                    <%
                        GroupsServiceImplement gs = new GroupsServiceImplement(DBConnect.getConnection());
                        List<Group> groupList = gs.getGroup();
                        for (Group group : groupList) {
                    %>
                    <option value="<%= group.getId()%>"><%= group.getGroupName()%></option>
                    <% }%>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Phone Number</label>
                <input type="text" class="form-control" id="exampleInputPassword1" name="phoneNumber" required="required" value="<%=contact.getPhoneNumber()%>">
            </div>
            <div class="text-center mt-2">
                <button type="submit" class="btn btn-danger text-white">Edit</button>
            </div>
        </form>
    </body>
</html>
