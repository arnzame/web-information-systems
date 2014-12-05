<%-- 
    Document   : login
    Created on : Dec 3, 2014, 2:31:24 PM
    Author     : charleshumphries
--%>
<% // mandate HTTPS
 if (! request.isSecure()) {
    String secureURL = request.getRequestURL().toString().replace("http", "https");
    secureURL = secureURL.replace("8084", "8443");
 response.sendRedirect(secureURL);
 }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/site.css" type="text/css" />
        <link rel="icon" type="image/png" href="http://s3.amazonaws.com/zim-prod-static/images/jmu_favicon.gif">
        <title>Login</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <h1>Welcome back!<h1>
        <form method="post" action="post" >
            <p>Username: <input type="text" name="username" size="25"></p>
            <p>Password: <input type="password" name="password" size="25"></p>
            <button type="submit"><a href="homeLogged.jsp">Login</a></button>
            <button type="button"><a href="newAccount.jsp">Create New Account</a></button>
            <button type="button"><a href="resetPassword.jsp">Reset Password</a></button>   
        </form>
    </body>
</html>
