package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class LoginDao {
	public AccountHolders avilable(HttpServletRequest req) throws SQLException {
		AccountHolders ah = null;
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("select * from bankdetails where USERID = ? and PASSWORD = ?");
		pr.setString(1, req.getParameter("id"));
		pr.setString(2, req.getParameter("pass"));
		ResultSet rs = pr.executeQuery();
		
		if(rs.next()) {
			ah = new AccountHolders();
			ah.setAccNumber(rs.getLong(1));
			ah.setUserName(rs.getString(2));
			ah.setUserId(rs.getString(3));
			ah.setBalance(rs.getDouble(4));
			ah.setAddress(rs.getString(5));
			ah.setPhNumber(rs.getLong(6));
			ah.setPassword(rs.getString(7));
			return ah;
		}
		else {
			return ah;
		}
		
		
	}
}
