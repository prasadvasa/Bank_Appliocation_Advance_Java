package com.bank;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		AccountHolders ah = new AccountHolders();
		ah.setAccNumber(Long.parseLong(req.getParameter("acc")));
		ah.setUserName(req.getParameter("name"));
		ah.setUserId(req.getParameter("id"));
		ah.setPassword(req.getParameter("pass"));
		ah.setBalance(1000);
		ah.setAddress(req.getParameter("add"));
		ah.setPhNumber(Long.parseLong(req.getParameter("ph")));
		try {
			int reg = new RegistrationDao().reg(ah);
			if(reg == 1) {
				ServletContext stc = req.getServletContext();
				stc.setAttribute("ah", ah);
				req.setAttribute("msg", "Your Registration is Successfully Compleated...");
			}
			else {
				req.setAttribute("msg", "Your Registration is not Successfully Compleated...");
			}
			req.getRequestDispatcher("RegSuccess.jsp").forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			req.setAttribute("msg", "Account Number is Already Exesisted please tyr again....");
			req.getRequestDispatcher("Error.jsp").forward(req, res);
			e.printStackTrace();
			
		}
	}
}
