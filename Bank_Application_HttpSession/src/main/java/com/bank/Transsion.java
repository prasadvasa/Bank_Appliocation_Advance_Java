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
@WebServlet("/trans")
public class Transsion extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req ,HttpServletResponse res)throws ServletException , IOException{
		try {
			AccountHolders first = new TranssionDao().update(req);
			 double bal = first.getBalance();
				if(first!=null) {
					req.setAttribute("msg", "Welcome "+first.getUserName()+" Your Transsion done...");
					req.setAttribute("amt", " "+Double.parseDouble(req.getParameter("amt")));
					req.setAttribute("bal", " "+bal);
					AccountHolders second = new TranssionDao().secondUpdate(req);
					ServletContext sct=req.getServletContext();
					sct.setAttribute("ah", second);
					LocalDateTime dt = LocalDateTime.now();
			        String acc = "ACCOUNTNUMBER"+String.valueOf(first.getAccNumber());
			        Connection con = DBConn.getCon();
			        PreparedStatement pt = con.prepareStatement("insert into "+acc+" values(?,?,?,?,?)");
					pt.setLong(1, first.getAccNumber());
					pt.setString(2, "Transsion to "+second.getUserName());
					pt.setInt(3, Integer.parseInt(req.getParameter("amt")));
					pt.setDouble(4, bal);
//					pt.setDate(6, dt1);
					pt.setTimestamp(5, Timestamp.valueOf(dt));
					int p1 = pt.executeUpdate();
				}
				else {
					req.setAttribute("msg", "Insufficient Balance Please Try Again....!");
				}
				
				req.getRequestDispatcher("Transsion.jsp").forward(req, res);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
