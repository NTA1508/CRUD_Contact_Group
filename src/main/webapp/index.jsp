<%-- 
    Document   : contacts
    Created on : Apr 5, 2024, 4:41:42 PM
    Author     : Admin
--%>

<%@page import="com.mycompany.ktgk_demon.models.Group"%>
<%@page import="com.mycompany.ktgk_demon.models.Contacts"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ktgk_demon.implement.GroupsServiceImplement"%>
<%@page import="com.mycompany.ktgk_demon.database.DBConnect"%>
<%@page import="com.mycompany.ktgk_demon.implement.ContactServiceImplement"%>
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
                    <th scope="col">Id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Group</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Operations</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ContactServiceImplement cs = new ContactServiceImplement(DBConnect.getConnection());
                    List<Contacts> contactList = cs.getContacts();
                    GroupsServiceImplement gs = new GroupsServiceImplement(DBConnect.getConnection());
                    Group group;
                    int id = 1;
                    for (Contacts contact : contactList) {
                %>
                <tr>
                    <td><%=id%></td>
                    <td><%=contact.getFirstName()%></td>
                    <td><%=contact.getLastName()%></td>
                    <td><%= gs.getGroupByID(contact.getGroupId()).getGroupName()%></td>
                    <td><%=contact.getPhoneNumber()%></td>
                    <td>
                        <a href="update_contact.jsp?id=<%=contact.getId()%>" class="btn btn-sm text-white" style="background-color: #f06292"><i class="fa-solid fa-pen-to-square"></i> Edit</a>
                        <a href="./delete_contact?id=<%=contact.getId()%>" class="btn btn-sm text-white" style="background-color: #880e4f"><i class="fa-solid fa-trash"></i> Delete</a>
                    </td>
                </tr>
                <%
                        id++;
                    }
                %>
            </tbody>
        </table>
        <a href="groups.jsp">Group</a>
        <a href="add_contact.jsp">Add Contact</a>
    </body>
</html>
