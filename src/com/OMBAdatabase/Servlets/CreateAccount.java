package com.OMBAdatabase.Servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OMBAdatabase.LoginServlet;
import com.OMBAdatabase.DaoFiles.AccountDao;
import com.OMBAdatabase.DaoFiles.UserDao;
import com.OMBAdatabase.ItemFiles.Account;
import com.OMBAdatabase.ItemFiles.User;

@SuppressWarnings("serial")
public class CreateAccount extends HttpServlet{
	
	private String message;
    int flag=0;
	
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException,ServletException {
		System.out.println("Creating new Account ");
		resp.setContentType("text/html");
		
		if(LoginServlet.login==1){ 
		String accountNo = checkAccountNo(req.getParameter("accountNo"));
		String customerId = checkCustomerId(req.getParameter("customerId"));
		String balance = checkBalance(req.getParameter("balance"));		
		String LstatDate1 = checkNull(req.getParameter("LstatDate1"));
		String LtransDate1 = checkNull(req.getParameter("LtransDate1"));
		String LstatDate2 = checkNull(req.getParameter("LstatDate2"));
		String LtransDate2 = checkNull(req.getParameter("LtransDate2"));
		String LstatDate3 = checkDate(req.getParameter("LstatDate3"));
		String LtransDate3 = checkDate(req.getParameter("LtransDate3"));
		String CDate1 = checkNull(req.getParameter("CDate1"));
		String CDate2 = checkNull(req.getParameter("CDate2"));
		String CDate3 = checkDate(req.getParameter("CDate3"));
        
		if(flag==0){
		AccountDao.INSTANCE.add(accountNo,customerId,balance,LstatDate1+"-"+LstatDate2+"-"+LstatDate3,
				LtransDate1+"-"+LtransDate2+"-"+LtransDate3,CDate1+"-"+CDate2+"-"+CDate3);

		resp.getWriter().println(" Account is added");

	}
    else{
    	String[] msg1=message.split(",");
    	for(String m1:msg1)
    	{
    		resp.getWriter().println(m1);
    	}
      }
		} else resp.sendRedirect("/JSPfiles/AdminLogin.jsp");
	}

	private String checkNull(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}
	private String checkAccountNo(String s)
	{
		if (s !=null && s.matches("\\d{12}")) {
			List<Account> a=AccountDao.INSTANCE.listAccounts();
		       
        	for(Account acc:a){
        		if((acc.getAccountNo()).equals(s)){
        		  flag=1;
        		  message+=",account already exists";
        		  return "";
        		}
        	}
            return s;
		
		}
		else{
		flag=1;
		message+=(",invalid account number");

		 }
		return "";
	}
	private String checkCustomerId(String s)
	{
		if (s != null && s.matches("\\d{8}")) {
			
			List<User> c=UserDao.INSTANCE.listCustomers();
	       
        	for(User cus:c){
        		if((cus.getCustomerId()).equals(s)){
        		  return s;
        		}
        	}
        	message+=",customer does not exists";
            return "";
		}
		else{
		flag=1;
		message+=(",invalid customer id");
		 }
		return "";
	}
	private String checkBalance(String s)
	{
		if (s != null && s.matches("^[1-9]\\d*(\\.\\d)?$")) {
			return s;
		
		}
		else{
		flag=1;
		message+=(",invalid balance");

		 }
		return "";
	}
	
	private String checkDate(String s) {
		if (s != null && s.matches("(19\\d{2})|(20[01]\\d)")) {
			return s;
		}
		else{
			flag=1;
		}
		message+=", Unacceptable year";
		return "";
	}
}

