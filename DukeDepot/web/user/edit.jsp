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
        <link rel="stylesheet" href="home.css" type="text/css" />
        <link rel="icon" type="image/png" href="http://s3.amazonaws.com/zim-prod-static/images/jmu_favicon.gif">
        <title>Edit Profile</title>
    </head>
    <body>
        <header class="mainHeader">
            <nav><ul>
                <li><a href="homeLogged.jsp">Home</a></li>
                <li><a href="index.jsp">Logout</a></li>
                <li><a href="#">Edit Profile</a></li>
            </ul></nav>
        </header>
        <h1>Edit Your Profile<h1>
        <form method="post" action="post">
            <table width="100%">
                <tr>
                    <td align="right">First Name:</td>
                    <td align="left"><input type="text" name="firstName" size="25" /></td>
                </tr>
                <tr>
                    <td align="right">Last Name:</td>
                    <td align="left"><input type="text" name="lastName" size="25" /></td>
                </tr>
                <tr>
                    <td align="right">Age:</td>
                    <td align="left"><input type="text" name="age" size="3" /></td>
                </tr>
                <tr>
                    <td align="right">Gender:</td>
                    <td align="left"><input type="text" name="gender" size="6" /></td>
                </tr>
            </table>
            
            <h3>Payment Info<h3>
            <table class="pay" width="100%">
                <tr>
                    <td align="right">Card Holder Name:</td>
                    <td align="left"><input type="text" name="cardName" size="40" /></td>
                </tr>
                <tr>
                    <td align="right">Card Number:</td>
                    <td align="left"><input type="text" name="cardNumber" size="25" /></td>
                </tr>
                <tr>
                    <td align="right">Expiration Date:</td>
                    <td align="left"><input type="text" name="expDate" size="10" /></td>
                </tr>
                <tr>
                    <td align="right">Security Code:</td>
                    <td align="left"><input type="text" name="securityCode" size="5" /></td>
                </tr>
                <tr>
                    <td align="right">Billing Address:</td>
                    <td align="left"><input type="text" name="billAddress" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">City:</td>
                    <td align="left"><input type="text" name="billCity" size="25" /></td>
                </tr>
                <tr>
                    <td align="right">State:</td>
                    <td align="left"><input type="text" name="billState" size="2" /></td>
                </tr>
                <tr>
                    <td align="right">Postal/Zip Code:</td>
                    <td align="left"><input type="text" name="billZip" size="15" /></td>
                </tr>
                <tr>
                    <td align="right">Country:</td>
                    <td align="left"><input type="text" name="billCountry" size="30" /></td>
                </tr>
            </table>
            
            <h3>Shipping Address</h3>
            <table class="ship" width="100%">
                <tr>
                    <td align="right">Full Name:</td>
                    <td align="left"><input type="text" name="fullName" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">Shipping Address:</td>
                    <td align="left"><input type="text" name="shipAddress" size="30"/></td>
                </tr>
                <tr>
                    <td align="right">City:</td>
                    <td align="left"><input type="text" name="shipCity" size="30"/></td>
                </tr>
                <tr>
                    <td align="right">State:</td>
                    <td align="left"><input type="text" name="shipState" size="2"/></td>
                </tr>
                <tr>
                    <td align="right">Postal/Zip Code:</td>
                    <td align="left"><input type="text" name="shipZip" size="15"/></td>
                </tr>
                <tr>
                    <td align="right">Country:</td>
                    <td align="left"><input type="text" name="shipCountry" size="30"/></td>
                </tr>
            </table>
            <button type="submit"><a href="#">Save Profile</a></button>
        </form>
    </body>
</html>