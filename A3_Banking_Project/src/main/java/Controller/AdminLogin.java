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

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		
		String name=req.getParameter("name");
		Bank_dao bank_dao=new Bank_dao();
		
		if(email.equals("admin@gmail.com") && name.equals("admin")) 
		{
			resp.getWriter().print("<h1>Admin_login_success</h1>");
			List<Bank_account> list= bank_dao.fetchAll();
			
			//session tracking
			
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("adminhome.jsp").include(req, resp);
		}
		else 
		{
			resp.getWriter().print("<h1>Invalid Credentials</h1>");
		}
	}
}
