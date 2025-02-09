<%@ page import="com.bank.DepositServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Status</title>
    <link rel="stylesheet" href="deposucc.css"> <!-- Link to the external CSS file -->
</head>
<body>
    <div id="con">
        <h4>
            <%
                String s = (String) request.getAttribute("msg");
                out.println(s);
            %>
        </h4>
        <h4>
            <%
                String s1 = (String) request.getAttribute("amt");
                out.println(s1);
            %>
        </h4>
        <button><a href="task.html">Home</a></button>
    </div>
</body>
</html>