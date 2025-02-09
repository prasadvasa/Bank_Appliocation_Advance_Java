package com.bank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException ,ServletException {
	  try {
		ArrayList<IndividualUser> retrive = new HistoryDao().retrive(req);
		 {
			ServletContext stc = req.getServletContext();
			stc.setAttribute("arry", retrive);
			req.getRequestDispatcher("history.jsp").forward(req, res);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
}
