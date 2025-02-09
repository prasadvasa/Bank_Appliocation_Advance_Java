<%@page import="com.bank.WithdrawServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw Success</title>
<link rel="stylesheet" type="text/css" href="withsucc.css"> <!-- Link to external CSS -->
</head>
<body>
<div class="container">
    <h1 class="greeting">Hello, 
    <% 
        String s = (String) request.getAttribute("name");
        out.println(s);
    %>
    </h1>
    <div class="message">
    <% 
        String s1 = (String) request.getAttribute("msg");
        String s2 = (String) request.getAttribute("with");
        String s3 = (String) request.getAttribute("bal");
        if (s2 == null || s3 == null) {
            out.println(s1);
        } else {
            out.println(s1);
    %>
    </div>
    <div class="details">
        <h5 class="withdraw-amount">Amount Withdrawn: &#8377; 
        <% 
            out.println(s2);
        %>
        </h5>
        <h5 class="balance">Remaining Balance: &#8377; 
        <% 
            out.println(s3);
        %>
        </h5>
    </div>
    <% } %>
    <button class="btn-home" onclick="goToHome()">Home</button>
</div>

<script>
    function goToHome() {
        window.location.href = "task.html"; // Redirect to home page
    }
</script>
</body>
</html>