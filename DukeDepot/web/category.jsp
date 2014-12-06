<%-- 
    Document   : category
    Created on : Dec 5, 2014, 10:21:17 PM
    Author     : aaron
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%  String category = request.getParameter("category");
    DBAccess db = new DBAccess();
    Connection conn = db.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Product WHERE category = '" + category + "';");
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/site.css" type="text/css" />
        <link rel="icon" type="image/png" href="http://s3.amazonaws.com/zim-prod-static/images/jmu_favicon.gif">
        <title><%=category %></title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <% 
            while (rs.next()){
                out.println("<div><h2>" + rs.getString("productName") + "</h2>");
                out.println("<p>" + rs.getFloat("price") + "</p>" );
                out.println("<p>" + rs.getString("size") + "</p>" );
                out.println("<a href=\"product.jsp?productID=" + rs.getInt("productID") + "\">Add to Cart</a>" );
            }
        %>
    </body>
</html>
