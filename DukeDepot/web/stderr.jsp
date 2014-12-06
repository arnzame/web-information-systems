<%-- 
    Document   : stderr
    Created on : Dec 5, 2014, 9:00:37 PM
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
        <p><%= session.getAttribute("message") %></p>
    </body>
</html>
