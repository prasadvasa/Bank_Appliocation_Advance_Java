<%@ page import="com.bank.RegisterServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Status</title>
<link rel="stylesheet" href="registration.css">
</head>
<body>
    <div class="container">
        <%
        String errorMessage = (String) request.getAttribute("msg");
        if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
            <div class="error-message">
                <%= errorMessage %>
            </div>
        <%
        }
        %>
        <%@include file="reg.html" %>
    </div>
</body>
</html>