<%@page import="java.util.List"%>
<%@page import="Dto.BankTransaction"%>
<%@page import="Dao.Bank_dao"%>
<%@page import="Dto.Bank_account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	long acno = (long) request.getSession().getAttribute("ac_number");
	Bank_dao bank_Dao = new Bank_dao();
	Bank_account bank_account = bank_Dao.find(acno);
	List<BankTransaction> list = bank_account.getList();
	%>
	<table border="1">
		<tr>
			<th>Tid</th>
			<th>Deposit</th>
			<th>Withdraw</th>
			<th>Transaction History</th>
			<th>Date</th>
		</tr>

		<%
		for (BankTransaction bankTransaction : list)
		{%>

        <tr>
			<th><%=bankTransaction.getTid() %></th>
			<th><%=bankTransaction.getDeposit()%></th>
			<th><%=bankTransaction.getWithdraw()%></th>
			<th><%=bankTransaction.getBalance()%></th>
			<th><%=bankTransaction.getDate_time()%></th>
		</tr>
		<%}%>

	</table>
	<a href="Accounthome.html"><button>Back</button></a>

</body>
</html>