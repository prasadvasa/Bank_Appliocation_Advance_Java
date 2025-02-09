<%@ page import="com.bank.LoginServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Balance</title>
<link rel="stylesheet" type="text/css" href="bal.css">
</head>
<body>
<div class="container">
    <h3>Your Bank Balance is: &#8377; 
    <% 
        AccountHolders ah = (AccountHolders) application.getAttribute("ah");
        out.println(ah.getBalance());
    %>
    </h3>
    <button onclick="goToHome()">Home</button> <!-- Button with action -->
</div>

<script>
    function goToHome() {
        window.location.href = "task.html"; // Redirect to home page
    }
</script>
</body>
</html>