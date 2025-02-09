package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class SetDao {
	public int update(HttpServletRequest req) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("update bankdetails set PASSWORD = ? where ACCOUNTNUMBER = ? and USERNAME= ? ");
		pr.setString(1, req.getParameter("setp"));
		pr.setLong(2, Long.parseLong(req.getParameter("acc")));
		pr.setString(3, req.getParameter("nam"));
		int p = pr.executeUpdate();
		return p;
		
	}
	public String name(HttpServletRequest req) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("select * from bankdetails where ACCOUNTNUMBER = ?");
		pr.setLong(1, Long.parseLong(req.getParameter("acc")));
		ResultSet rs = pr.executeQuery();
		rs.next();
		String n = rs.getString(2);
		return n;
		
	}

}
