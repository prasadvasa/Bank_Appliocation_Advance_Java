package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;

public class HistoryDao {
	public ArrayList<IndividualUser> retrive(HttpServletRequest req) throws SQLException{
		ArrayList<IndividualUser> li = new ArrayList<IndividualUser>();
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("select * from bankdetails where PASSWORD = ?");
		pr.setString(1, req.getParameter("pword"));
		ResultSet rs = pr.executeQuery();
		
		if(rs.next()) {
			String accNam = rs.getString(8);
			PreparedStatement p1 = con.prepareStatement("select * from "+accNam+"");
			ResultSet r1 = p1.executeQuery();
			while(r1.next()) {
				IndividualUser iu = new IndividualUser();
				iu.setAcc(r1.getLong(1));
				iu.setAction(r1.getString(2));
				iu.setTransAmt(r1.getDouble(3));
				iu.setBal(r1.getDouble(4));
				iu.setTs(r1.getTimestamp(5));
				li.add(iu);
			}
			return li;
		}
		else {
			return null;
		}
		
		
		
	}
}
