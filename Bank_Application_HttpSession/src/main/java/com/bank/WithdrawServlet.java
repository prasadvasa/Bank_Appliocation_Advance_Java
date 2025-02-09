package com.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/with")
public class WithdrawServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req ,HttpServletResponse res)throws ServletException ,IOException{
		try {
			Double bal = new WithdrawDao().update(req);
			String nam = new WithdrawDao().name(req);
			System.out.println(nam);
			if(bal<=0) {
				req.setAttribute("name", nam);
				req.setAttribute("msg", "Insufficient Balance Pleace try Again......!");
//				req.setAttribute("with", "Balance ");
//				req.setAttribute("bal", "Pleace try Again......!");
			}
			else {
				ServletContext stc = req.getServletContext();
				AccountHolders ah = (AccountHolders) stc.getAttribute("ah");
				req.setAttribute("name", nam);
				req.setAttribute("msg", "Your Transsion is Completed Successfully");
				req.setAttribute("with", " "+Double.parseDouble(req.getParameter("amt")));
				req.setAttribute("bal", " "+bal);
				stc.setAttribute("ah", ah);
				System.out.println(nam);
				LocalDateTime dt = LocalDateTime.now();
		        String acc = "ACCOUNTNUMBER"+String.valueOf(req.getParameter("acc"));
		        Connection con = DBConn.getCon();
		        PreparedStatement pt = con.prepareStatement("insert into "+acc+" values(?,?,?,?,?)");
				pt.setLong(1, ah.getAccNumber());
				pt.setString(2, "Withdraw");
				pt.setInt(3, Integer.parseInt(req.getParameter("amt")));
				pt.setDouble(4, bal);
//				pt.setDate(6, dt1);
				pt.setTimestamp(5, Timestamp.valueOf(dt));
				int p1 = pt.executeUpdate();
			}
			req.getRequestDispatcher("Withdraw.jsp").forward(req, res);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
