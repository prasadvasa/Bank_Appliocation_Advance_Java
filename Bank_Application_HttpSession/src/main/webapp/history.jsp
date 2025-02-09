
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.bank.HistoryServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.bank.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History - Prasad Bank</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            min-height: 100vh;
            background: linear-gradient(rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)),
                        url('/api/placeholder/1920/1080') center/cover;
        }

        .container {
            max-width: 1000px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.95);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #1a365d;
            margin-bottom: 30px;
            font-size: 2.5em;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
        }

        .transaction-table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0;
            margin: 20px 0;
            background: white;
            border: 2px solid #1a365d;
            border-radius: 8px;
            overflow: hidden;
        }

        .transaction-table th,
        .transaction-table td {
            border: 1px solid #ccd5e0;
            padding: 15px;
            text-align: left;
        }

        .transaction-table th {
            background-color: #1a365d;
            color: white;
            font-weight: bold;
            border-color: #2c5282;
        }

        .transaction-table tr:nth-child(odd) {
            background-color: #ffffff;
        }

        .transaction-table tr:nth-child(even) {
            background-color: #edf2f7;
        }

        .transaction-table tr:hover {
            background-color: #e8f4ff;
            transition: background-color 0.3s ease;
        }

        .status-deposit {
            color: #388e3c;
            font-weight: bold;
        }

        .status-withdrawal {
            color: #d32f2f;
            font-weight: bold;
        }

        .home-button {
            display: block;
            width: 200px;
            margin: 30px auto;
            padding: 12px 24px;
            background-color: #1a365d;
            color: white;
            text-decoration: none;
            text-align: center;
            border-radius: 5px;
            border: none;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .home-button:hover {
            background-color: #2c5282;
            transform: translateY(-1px);
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .no-data {
            text-align: center;
            color: #d32f2f;
            padding: 40px;
            font-size: 1.2em;
            border: 2px dashed #d32f2f;
            border-radius: 8px;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome To Prasad Bank</h1>
        
        <%

        ArrayList<IndividualUser> li = (ArrayList<IndividualUser>) application.getAttribute("arry");

        if(li==null || li.isEmpty()){
        %>
        <div class="no-data">
            <h2>There are No Transaction Records Available Right Now!</h2>
        </div>
        <%
        } else {
        %>
        <table class="transaction-table">
            <thead>
                <tr>
                    <th>Account Number</th>
                    <th>Action</th>
                    <th>Transaction Amount</th>
                    <th>Balance</th>
                    <th>Time</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <%
            Iterator<IndividualUser> it = li.iterator();
            while(it.hasNext()){
                IndividualUser iu = (IndividualUser)it.next();
            %>
                <tr>
                    <td><%= iu.getAcc() %></td>
                    <td><%= iu.getAction() %></td>
                    <td>₹ <%= String.format("%,.2f", iu.getTransAmt()) %></td>
                    <td>₹ <%= String.format("%,.2f", iu.getBal()) %></td>
                    <td><%= iu.getTs() %></td>
                    <td><%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %></td>
                    <td class="<%= iu.getAction().toLowerCase().contains("deposit") ? "status-deposit" : "status-withdrawal" %>">
                        <%= iu.getAction().toLowerCase().contains("deposit") ? "CREDITED" : "DEBITED" %>
                    </td>
                </tr>
            <%
            }
            }
            %>
            </tbody>
        </table>
        
        <a href="task.html" class="home-button">Return to Home</a>
    </div>
</body>
</html>