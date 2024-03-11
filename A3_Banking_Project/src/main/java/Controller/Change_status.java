package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Bank_dao;
import Dto.Bank_account;
@WebServlet("/changestatus")
public class Change_status extends HttpServlet
{
	@Override
	
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String ac_No=req.getParameter("acno");
			
			long acc_no=Long.parseLong(ac_No);
			
			Bank_dao bankDao = new Bank_dao();
			
			   Bank_account bank_account =   bankDao.Bank_account_fetch_account_details( acc_no);
			   
			   if(bank_account.isStatus())
			   {
				   bank_account.setStatus(false);
			   }
			   else
			   {
				   bank_account.setStatus(true);
			   }
			   
			   bankDao.update_the_account_status(bank_account);
			   
			   
			   // here i am going to take updated information from bank account and display the updated information into the the data base
			   //through session tracking concept
			   
			   List<Bank_account> account_Information =bankDao.fetchAll();
			   req.getSession().setAttribute("list", account_Information);
			   
			   req.getRequestDispatcher("adminhome.jsp").include(req, resp);
			
		}
	}

