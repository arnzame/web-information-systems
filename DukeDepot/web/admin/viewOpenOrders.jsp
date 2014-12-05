<%-- 
    Document   : viewOpenOrders
    Created on : Dec 4, 2014, 7:36:01 PM
    Author     : aaron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <th>
                <td>Order #</td>
                <td>User</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td></td>
            </th>
        <%
        String sql = "SELECT DISTINCT userID FROM Orders;";     
        %>
        </table>
    </body>
</html>
