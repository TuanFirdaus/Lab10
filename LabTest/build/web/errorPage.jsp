<%-- 
    Document   : errorPage
    Created on : 12 Jun 2024, 8:13:34 am
    Author     : tfird
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h2>Error</h2>
    <p><%= request.getAttribute("errorMessage") %></p>
    <a href="index.jsp">Go to Home</a>
</body>
</html>
