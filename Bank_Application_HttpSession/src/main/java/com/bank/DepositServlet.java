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
@WebServlet("/dep")
public class DepositServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		try {
			double p = new DepositeDao().update(req);
			double k = Double.parseDouble(req.getParameter("amt"));
			ServletContext stc = req.getServletContext();
			if(p>1) {
				AccountHolders ah = (AccountHolders) stc.getAttribute("ah");
				ah.setBalance(p);
				req.setAttribute("msg", k+" Amount is Successfully Deposited....");
				req.setAttribute("amt", "\n Your Current Balance is : "+p);
				stc.setAttribute("ah", ah);
				LocalDateTime dt = LocalDateTime.now();
		        String acc = "ACCOUNTNUMBER"+String.valueOf(ah.getAccNumber());
		        Connection con = DBConn.getCon();
		        PreparedStatement pt = con.prepareStatement("insert into "+acc+" values(?,?,?,?,?)");
				pt.setLong(1, ah.getAccNumber());
				pt.setString(2, "Deposit");
				pt.setInt(3, (int)k);
				pt.setDouble(4, p);
//				pt.setDate(6, dt1);
				pt.setTimestamp(5, Timestamp.valueOf(dt));
				int p1 = pt.executeUpdate();
			}
			else {
				req.setAttribute("msg", "Invalid Account Number Or MisMatch Amount");
			}
			req.getRequestDispatcher("Deposite.jsp").forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
