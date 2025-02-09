package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class WithdrawDao {
	public Double update(HttpServletRequest req) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement pr1 = con.prepareStatement("select * from bankdetails where accountnumber = ?");
		pr1.setLong(1, Long.parseLong(req.getParameter("acc")));
		ResultSet rs = pr1.executeQuery();
		rs.next();
		double bal = rs.getDouble(4);
		if(bal>= Double.parseDouble((String) req.getParameter("amt"))) {
			
		PreparedStatement pr = con.prepareStatement("update bankdetails set balance = balance - ? where accountnumber = ?");
		pr.setDouble(1,Double.parseDouble(req.getParameter("amt")));
		pr.setLong(2, Long.parseLong(req.getParameter("acc")));
		int k = pr.executeUpdate();
		PreparedStatement pr2 = con.prepareStatement("select * from bankdetails where accountnumber = ?");
		pr2.setLong(1, Long.parseLong(req.getParameter("acc")));
		ResultSet rs1 = pr2.executeQuery();
		rs1.next();
		 bal = rs1.getDouble(4);
		return bal;
		}
		else {
			return (double) 0;
		}
	}
	public String name(HttpServletRequest req) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement pq = con.prepareStatement("select * from bankdetails where accountnumber = ?");
		pq.setLong(1, Long.parseLong(req.getParameter("acc")));
		ResultSet rs = pq.executeQuery();
		rs.next();
		String bal = rs.getString(2);
		
		return bal;
	}
}
