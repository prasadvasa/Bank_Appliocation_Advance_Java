package com.bank;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
		try {
			
			AccountHolders ah = null;
			 ah = new LoginDao().avilable(req);
			 double bal = ah.getBalance();
			if(ah!=null) {
				req.setAttribute("msg", "Welcome "+ah.getUserName());
				req.setAttribute("bal", " "+bal);
				ServletContext sct=req.getServletContext();
				sct.setAttribute("ah", ah);
//				LocalDateTime dt = LocalDateTime.now();
				LocalDateTime dt = LocalDateTime.now();
		        String acc = "ACCOUNTNUMBER"+String.valueOf(ah.getAccNumber());
		        Connection con = DBConn.getCon();
		        PreparedStatement pt = con.prepareStatement("insert into "+acc+" values(?,?,?,?,?)");
				pt.setLong(1, ah.getAccNumber());
				pt.setString(2, "Login");
				pt.setInt(3, 0);
				pt.setDouble(4, bal);
//				pt.setDate(6, dt1);
				pt.setTimestamp(5, Timestamp.valueOf(dt));
				int p1 = pt.executeUpdate();
			}
			else {
				req.setAttribute("msg", "Invalid UserName Or UserId");
			}
			
			req.getRequestDispatcher("loginSuccess.jsp").forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
