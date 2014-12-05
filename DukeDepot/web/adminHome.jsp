<%-- 
    Document   : index
    Created on : Dec 2, 2014, 10:02:27 PM
    Author     : charleshumphries
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="home.css" type="text/css" />
        <link rel="icon" type="image/png" href="http://s3.amazonaws.com/zim-prod-static/images/jmu_favicon.gif">
        <title>The Duke Depot</title>
    </head>
    <body>
        <header class="mainHeader">
            <img src="http://cdn.fansided.com/wp-content/blogs.dir/249/files/2013/09/jmu.jpg" style="vertical-align: middle"/>
            <h1>The Duke Depot</h1>
            
            <nav><ul>
                <li class="active"><a href="#">Home</a></li>
                <li><a href="index.jsp">Log Out</a></li>
                <li><a href="accountList.jsp">View Accounts</a></li>
                <li><a href="editProducts.jsp">Edit Products</a></li>
                <li><a href="viewOrders.jsp">View Orders</a></li>
            </ul></nav>
        </header>
        <h1>Browse Our Products</h1>
        
        <table width="100%" border="0" cellpadding="5">
            <tr>
                <td align="center" valign="center"><img src="http://images.footballfanatics.com/FFImage/thumb.aspx?i=/productImages/_743000/ff_743554_xl.jpg&w=180" 
                alt="Men Clothes" /> <br />
                <button type="button"><a href="menClothing.jsp">Men's Clothing</a></button></td>
                <td align="center" valign="center"><img src="http://bkstr.scene7.com/is/image/Bkstr/712-C5344-P2427272-C-Purple?$GMCategory$"
                alt="Women Clothes" /> <br />
                <button type="button"><a href="womenClothing.jsp">Women's Clothing</a></button></td>
                <td align="center" valign="center"><img src="http://bkstr.scene7.com/is/image/Bkstr/712-10802-114510-Purple?$GMCategory$"
                alt="Kid Clothes" /> <br />
                <button type="button"><a href="kidClothing.jsp">Kid's Clothing</a></button></td>
            </tr>
        </table>
    </body>
</html>