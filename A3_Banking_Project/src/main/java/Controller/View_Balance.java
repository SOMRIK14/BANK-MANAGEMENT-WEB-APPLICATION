package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Bank_dao;
import Dto.Bank_account;

@WebServlet("/viewBalance")
public class View_Balance extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	Long  acno	=(Long)req.getSession().getAttribute("ac_number");
	Bank_dao bank_account=new Bank_dao();
	
	Bank_account account_info=bank_account.find(acno);
	
	double ac_balance=account_info.getAmount();
	
	
	resp.getWriter().print("<h1>Your Current Account balance is :"+ac_balance+"</h1>");
	
	req.getRequestDispatcher("backButton.html").include(req, resp);
	
	}

}
