<%-- 
    Document   : newAccount
    Created on : Dec 3, 2014, 6:31:19 PM
    Author     : charleshumphries
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/site.css" type="text/css" />
        <link rel="icon" type="image/png" href="http://s3.amazonaws.com/zim-prod-static/images/jmu_favicon.gif">
        <title>Create New Account</title>
    </head>
    <body>
        <header class="mainHeader">
            <nav><ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul></nav>
        </header>
        <h1>Sign Up<h1>
        <form method="post" action="post">
            <table width="100%">
                <tr>
                    <td align="right">Username:</td>
                    <td align="left"><input type="text" name="username" size="25" /></td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td align="left"><input type="password" name="password" size="25" /></td>
                </tr>
                <tr>
                    <td align="right">Security Question:</td>
                    <td align="left"><input type="text" name="question" size="50" /></td>
                </tr>
                <tr>
                    <td align="right">Answer:</td>
                    <td align="left"><input type="text" name="answer" size="50" /></td>
                </tr>
            </table>
            <button type="submit"><a href="#">Create Account</a></button>
        </form>
    </body>
</html>