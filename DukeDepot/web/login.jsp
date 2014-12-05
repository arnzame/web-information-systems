<%-- 
    Document   : login
    Created on : Dec 3, 2014, 2:31:24 PM
    Author     : charleshumphries
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="login.css" type="text/css" />
        <link rel="icon" type="image/png" href="http://s3.amazonaws.com/zim-prod-static/images/jmu_favicon.gif">
        <title>Login</title>
    </head>
    <body>
        <header class="mainHeader">
            <nav><ul>
                <li><a href="index.jsp">Home</a></li>
                <li class="active"><a href="#">Login</a></li>
            </ul></nav>
        </header>
        <h1>Welcome back!<h1>
        <form method="post" action="post">
            <p>Username: <input type="text" name="username" size="25"></p>
            <p>Password: <input type="password" name="password" size="25"></p>
            <button type="submit"><a href="homeLogged.jsp">Login</a></button>
            <button type="button"><a href="newAccount.jsp">Create New Account</a></button>
            <button type="button"><a href="resetPassword.jsp">Reset Password</a></button>   
        </form>
    </body>
</html>
