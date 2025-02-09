<%@page import="java.time.LocalDate"%>
<%@ page import="com.bank.LoginServlet" %>
<%@ page import="java.time.*" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
<link rel="stylesheet" type="text/css" href="loginsuccess.css"> 
</head>
<body>
<div class="container">
    <h2>
    <% 
    	
        String s = (String) request.getAttribute("msg");
        out.println(s);
        
        
    %>
    
    </h2>
    <button><a href="task.html">Home</a></button>
</div>
</body>
</html>