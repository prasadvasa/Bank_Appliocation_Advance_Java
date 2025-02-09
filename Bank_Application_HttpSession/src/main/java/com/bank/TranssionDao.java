package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class TranssionDao {
	public AccountHolders update(HttpServletRequest req) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("select * from bankdetails where accountnumber = ?");
		pr.setLong(1, Long.parseLong(req.getParameter("sen")));
		ResultSet rs = pr.executeQuery();
		rs.next();
		if((Double.parseDouble(req.getParameter("amt")))<= rs.getDouble(4)) {
			PreparedStatement pr1 = con.prepareStatement("update bankdetails set balance = balance - ? where accountnumber = ?");
			pr1.setDouble(1, Double.parseDouble(req.getParameter("amt")));
			pr1.setLong(2, Long.parseLong(req.getParameter("sen")));
			int p = pr1.executeUpdate();
			PreparedStatement pr2 = con.prepareStatement("select * from bankdetails where accountnumber = ?");
			pr2.setLong(1, Long.parseLong(req.getParameter("sen")));
			ResultSet rs1 = pr2.executeQuery();
			rs1.next();
			AccountHolders ah = new AccountHolders();
			ah.setAccNumber(rs1.getLong(1));
			ah.setUserName(rs1.getString(2));
			ah.setUserId(rs1.getString(3));
			ah.setBalance(rs1.getDouble(4));
			ah.setAddress(rs1.getString(5));
			ah.setPhNumber(rs1.getLong(6));
			ah.setPassword(rs1.getString(7));
			new TranssionDao().second(req);
			return ah;
		}
		else {
			return null;
		}
		
	}

	private void second(HttpServletRequest req) throws SQLException {
		
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("update bankdetails set balance = balance + ? where accountnumber = ?");
		pr.setDouble(1, Double.parseDouble(req.getParameter("amt")));
		pr.setLong(2, Long.parseLong(req.getParameter("res")));
		int p = pr.executeUpdate();
	}
	public AccountHolders secondUpdate(HttpServletRequest req) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("select * from bankdetails where accountnumber = ?");
		pr.setLong(1, Long.parseLong(req.getParameter("res")));
		ResultSet rs1 = pr.executeQuery();
		rs1.next();
		AccountHolders ah = new AccountHolders();
		ah.setAccNumber(rs1.getLong(1));
		ah.setUserName(rs1.getString(2));
		ah.setUserId(rs1.getString(3));
		ah.setBalance(rs1.getDouble(4));
		ah.setAddress(rs1.getString(5));
		ah.setPhNumber(rs1.getLong(6));
		ah.setPassword(rs1.getString(7));
		
		return ah;
		
	}
	
}
