<%-- 
    Document   : passwordReset
    Created on : Dec 3, 2014, 7:02:35 PM
    Author     : charleshumphries
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resetPassword.css" type="text/css" />
        <link rel="icon" type="image/png" href="http://s3.amazonaws.com/zim-prod-static/images/jmu_favicon.gif">
        <title>Reset Password</title>
    </head>
    <body>
        <header class="mainHeader">
            <nav><ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul></nav>
        </header>
        <h1>Password Reset</h1>
        <div class="reset">
            <form method="post" action="hello">
                <h1>Username: <input type="text" name="username" size="25"></h1>
                <p><button type="submit"><a href="#">Reset Password</a></button></p>
            </form>
        </div>
    </body>
</html>
