<%@ page import="com.bank.Transsion" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Success</title>
<link rel="stylesheet" type="text/css" href="transuccess.css"> 
</head>
<body>
<div class="container">
    <h2 class="success-message">
    <% 
        String s1 = (String) request.getAttribute("msg");
        out.println(s1);
    %>
    </h2>
    <div class="transaction-details">
        <h4 class="amount">
        <% 
            String s2 = (String) request.getAttribute("amt");
            out.println("Amount Transferred: &#8377; " + s2);
        %>
        </h4>
        <h4 class="receiver">
        <% 
            AccountHolders ah = (AccountHolders) application.getAttribute("ah");
            out.println("Sent To: " + ah.getUserName());
        %>
        </h4>
        <h4 class="balance">
        <% 
            String s3 = (String) request.getAttribute("bal");
            out.println("Remaining Balance: &#8377; " + s3);
        %>
        </h4>
    </div>
    <button class="btn-home" onclick="goToHome()">Home</button>
</div>

<script>
    function goToHome() {
        window.location.href = "task.html"; // Redirect to home page
    }
</script>
</body>
</html>