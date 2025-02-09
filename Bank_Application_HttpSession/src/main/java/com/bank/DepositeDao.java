package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class DepositeDao {
	public Double update(HttpServletRequest req) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement p1 = con.prepareStatement("select * from bankdetails where accountnumber=?");
		PreparedStatement pr = con
				.prepareStatement("update bankdetails set balance = balance + ? where accountnumber = ?");
		pr.setDouble(1, Double.parseDouble(req.getParameter("amt")));
		pr.setLong(2, Long.parseLong(req.getParameter("num")));
		p1.setLong(1, Long.parseLong(req.getParameter("num")));
		int k = pr.executeUpdate();
		ResultSet rs = p1.executeQuery();
		double bal = 0;
		while (rs.next()) {
			bal = rs.getDouble(4);
		}
		System.out.println(bal);
		return bal;
	}

}
