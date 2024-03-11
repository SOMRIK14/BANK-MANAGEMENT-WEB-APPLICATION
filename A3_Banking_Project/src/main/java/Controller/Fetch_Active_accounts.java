package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Bank_account;
import Dto.Customer;

@WebServlet("/fetchactiveaccount")
public class Fetch_Active_accounts extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Customer	customer	=(Customer) req.getSession().getAttribute("customer");
	List<Bank_account> list=customer.getBankaccounts();
	List<Bank_account> list2    = new ArrayList<>();
	for (Bank_account bank_account : list) 
	{
		if(bank_account.isStatus()) 
		{
//			System.out.println("status is active");
			list2.add(bank_account);
		}
		else 
		{
//			System.out.println("Status is inactive");
		}
	}
	req.getSession().setAttribute("list", list2);
	req.getRequestDispatcher("accounts.jsp").include(req, resp);
	
		
	}
}
