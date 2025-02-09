package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
//	private static Connection con = null;
//	static{
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe:1521","HemaVasa","Hemavasa");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public static Connection getcon() {
//		
//		return con;
//		
//	}
	private static Connection con = null;
	private DBConn() {
		
	}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","HemaVasa","HemaVasa");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}

}
