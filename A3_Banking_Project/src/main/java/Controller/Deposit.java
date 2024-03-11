package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Bank_dao;
import Dto.BankTransaction;
import Dto.Bank_account;

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
		String amt = req.getParameter("amnt");
		double amount= Double.parseDouble(amt);
		
		Long acno=(Long)req.getSession().getAttribute("ac_number");
		
		Bank_dao bank_dao=new Bank_dao();
		
		Bank_account bank_account=bank_dao.find(acno);
		
		bank_account.setAmount(bank_account.getAmount()+amount);
		
		
		BankTransaction bankTransaction=new BankTransaction();
		//bankTransaction.setTid();
		bankTransaction.setDeposit(amount);
		bankTransaction.setWithdraw(0);
		bankTransaction.setBalance(bank_account.getAmount());
		bankTransaction.setDate_time(LocalDateTime.now());
		
		
		List<BankTransaction> list2=bank_account.getList(); //fetching the previous transaction in bank account table
		list2.add(bankTransaction);//adding the new transaction along with previous in bank account table
		bank_account.setList(list2);//setting the data in bank account
		
		
		bank_dao.update_the_account_status(bank_account);
		
		resp.getWriter().print("<h1>amount deposited succesfully</h1>");
	}
}
