<%@ page import="com.bank.RegisterServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <link rel="stylesheet" href="regsucc.css"> <!-- Link to the external CSS file -->
</head>
<body>
    <div class="container">
        <h1>Welcome to Prasad Bank</h1>
        <%
            AccountHolders ah = (AccountHolders) application.getAttribute("ah");
            String s = (String) request.getAttribute("msg");
        %>
        <p>Welcome, <%= ah.getUserName() %>!</p>
        <p><%= s %></p>
        <button onclick="window.location.href='AdminLogin.html'">Login</button> <!-- Add action for the button -->
    </div>
</body>
</html>