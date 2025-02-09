package com.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RegistrationDao {
	public int reg(AccountHolders ah) throws SQLException {
		Connection con = DBConn.getCon();
		PreparedStatement pr = con.prepareStatement("insert into bankdetails values(?,?,?,?,?,?,?,?)");
		pr.setLong(1, ah.getAccNumber());
		pr.setString(2, ah.getUserName());
		pr.setString(3, ah.getUserId());
		pr.setDouble(4, ah.getBalance());
		pr.setString(5, ah.getAddress());
		pr.setLong(6, ah.getPhNumber());
		pr.setString(7, ah.getPassword());
		pr.setString(8, "acc");
		int p = pr.executeUpdate();
		System.out.println(p);
		if(p==1) {
			LocalDateTime dt = LocalDateTime.now();
//			Date dt1= Date.valueOf(dt);
			String acc = "ACCOUNTNUMBER"+String.valueOf(ah.getAccNumber());
			CallableStatement cb = con.prepareCall("{call accountholders (?)}");
			cb.setString(1, String.valueOf(ah.getAccNumber()));
			cb.execute();
		//	String acc = "ACCOUNTNUMBER"+String.valueOf(ah.getAccNumber());
			PreparedStatement pt = con.prepareStatement("insert into "+acc+" values(?,?,?,?,?)");
			pt.setLong(1, ah.getAccNumber());
			pt.setString(2, "Register");
			pt.setInt(3, 0);
			pt.setDouble(4, ah.getBalance());
//			pt.setDate(6, dt1);
			pt.setTimestamp(5, Timestamp.valueOf(dt));
			int p1 = pt.executeUpdate();
			PreparedStatement pq = con.prepareStatement("update bankdetails set ACCTABNAM = ? where accountnumber = ? ");
			pq.setString(1, acc);
			pq.setLong(2, ah.getAccNumber());
			int p2 = pq.executeUpdate();
			System.out.println(p2);

			
			
		}
		return p;
		
		
	}

	
}
