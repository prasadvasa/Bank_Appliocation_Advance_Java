package com.bank;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/forgot")
public class ForgotServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException , ServletException
	{
		if(req.getParameter("setp").equals(req.getParameter("conp"))) {
			AccountHolders ah = new AccountHolders();
			try {
				int p = new SetDao().update(req);
				String nam = new SetDao().name(req);
				if(p==1) {
					req.setAttribute("nam", "Welcome "+ nam);
					req.setAttribute("msg", "Your New Password Successfully Updated .....");
					
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
					req.setAttribute("msg", "Invalid Account Number or Invalid User Name ...Please Try Again.....!");
			}
		}
		else {
			req.setAttribute("msg", "Password is MisMach....! Please try again...!");
		}
		req.getRequestDispatcher("forgot.jsp").forward(req, res);
		
	}

}
