<%@ page import="com.bank.ForgotServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Forgot Password</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url('his.jpg'); /* Replace with your bank-related background image */
        background-size: cover;
        background-position: center;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        text-align: center;
        max-width: 400px;
        width: 100%;
    }

    h1 {
        color: #333;
        margin-bottom: 20px;
    }

    .message {
        font-size: 18px;
        color: #555;
        margin-bottom: 20px;
    }

    .button {
        background-color: #007BFF;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
    <h1> Welcome TO Prasad Bank</h1>
        <h2>
        <div class="message">
            <%
            String s1 = (String) request.getAttribute("nam");
            out.println(s1);
            %>
            </h2>
            <h3><%
            String s2 = (String) request.getAttribute("msg");
            
            out.println("<br>");
            out.println(s2);
            %></h3>
            <button class="button"><a href="AdminLogin.html" style="color: white; text-decoration: none;">Login</a></button>
        </div>
        
    </div>
</body>
</html>