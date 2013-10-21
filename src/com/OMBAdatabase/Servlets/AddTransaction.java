package com.OMBAdatabase.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import com.OMBAdatabase.LoginServlet;
import com.OMBAdatabase.DaoFiles.AccountDao;
import com.OMBAdatabase.DaoFiles.BeneficiaryDao;
import com.OMBAdatabase.DaoFiles.TransactionDao;
import com.OMBAdatabase.ItemFiles.Account;
import com.OMBAdatabase.ItemFiles.Beneficiary;


@SuppressWarnings("serial")
public class AddTransaction extends HttpServlet {
	
	String message,balance;
	int flag=0;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		    resp.setContentType("text/html");
		    
		    message="";
		    balance="";
		    if(LoginServlet.login==1){ 
            
			String customerId= checkCustomerId(req.getParameter("customerId"));
			String dot1= req.getParameter("dot1");
			String dot2=req.getParameter("dot2");
			String dot3= checkDate(req.getParameter("dot3"));
			String time=(req.getParameter("time"));

			String toAccount=checkToAccountNo(req.getParameter("toAccount"));
			String amount = checkAmount(req.getParameter("amount"));
			String description = checkIsNull(req.getParameter("description"));
			balance+=checkBalance(req.getParameter("balance"));
			String toAccBalance = checkIsNull(req.getParameter("toAccBalance"));
			String accountNo=checkAccountNo(req.getParameter("accountNo"),customerId);

        if(flag==0){
			
			TransactionDao.INSTANCE.add(customerId,accountNo,dot1+"-"+dot2+"-"+dot3,
					time,toAccount,amount,balance,toAccBalance,description);
			resp.getWriter().println("Transaction is added");
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

	private String checkCustomerId(String s) {
			if (s != null && s.matches("\\d{8}")) {
				List<Account> a=AccountDao.INSTANCE.listAccounts();
		       	for(Account acc:a){
	        		if((acc.getCustomerId()).equals(s)){
	        		  return s;
	        		}
	        	}
		       	flag=1;
      		    message+=",customer does not exist";
	        			return "";
			}
			else{
			flag=1;
			message+=(",invalid customer id");

			 }
			return "";

			}
		private String checkAccountNo(String s,String c) {
			if (s != null && s.matches("\\d{12}")) {
				List<Account> a=AccountDao.INSTANCE.listAccounts();
		       	for(Account acc:a){
	        		if((acc.getAccountNo()).equals(s)){	        			
	        			if((acc.getCustomerId()).equals(c)){
	        				AccountDao.INSTANCE.updateBalance(acc.getId(),balance);
	        		            return s;
	        			}
	        			else{
	        				flag=1;
	        				message+=",Corresponding customer id is wrong";
	        				return "";
	        			}
	        		}
	        	}
		       	flag=1;
      		    message+=",account does not exist";
	        			return "";
			}
			else{
				flag=1;
				message+=(",invalid account number");			
			 }
			return "";

			}
		
		private String checkDate(String s) {
			if (s != "" && s.matches("(19\\d{2})|(20[01]\\d)")) {
				
               return s;
			}
			else{
				flag=1;
				message+=(",invalid year");			
			 }
			return "";

			}
		private String checkToAccountNo(String s) {
			if (s != "" && s.matches("\\d{12}")) {
				List<Beneficiary> a=BeneficiaryDao.INSTANCE.listBeneficiaries();
		       	for(Beneficiary acc:a){
	        		if((acc.getBeneficiaryAccountNo()).equals(s)){
	        		  return s;
	        		}
	        	}
		       	flag=1;
      		    message+=",account does not exist";
	        			return "";

			}
			else{
			flag=1;
			message+=(",invalid to account number");

			 }
            return "";
			}
		
		private String checkAmount(String s) {
			if (s != "" && s.matches("^[1-9]\\d*(\\.\\d)?$")) {
					return s;
	        }
			else{
					flag=1;
					message+=(",invalid amount");
			 }
			return "";
		}
		
		private String checkBalance(String s) {
			if (s != "" && s.matches("^[1-9]\\d*(\\.\\d)?$") ) {
				return s;	
			}
			else{
				flag=1;
				message+=(",Invalid balance");
			 }
               return "";
			}
		private String checkIsNull(String s) {
			if (s != "" ) {
			return s;	
			}
			else{
			flag=1;
			message+=(",Invalid description");

			 }
               return "";
			}

		}
