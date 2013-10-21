package com.OMBAdatabase.XMLservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OMBAdatabase.LoginServlet;
import com.OMBAdatabase.DaoFiles.TransactionDao;
import com.OMBAdatabase.ItemFiles.Transaction;

@SuppressWarnings("serial")
public class DisplayTransactionXML extends HttpServlet    
{  

public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  
 {  
	
	 resp.setContentType("text/xml");
	 if(LoginServlet.login==1){ 
	 List<Transaction> transactions = TransactionDao.INSTANCE.listTransactions();
	 
	 PrintWriter out=resp.getWriter(); 
	  out.println("<Transactions>");  
	  
	  //loop through items list and print each item  
	  for (Transaction t : transactions)   
	        {  
	   out.println("\n\t<Transaction>");
	   out.println("\n\t\t<CustomerId>"+t.getCustomerId()+"</CustomerId>");
	   out.println("\n\t\t<AccountNo> " + t.getAccountNo() +"</AccountNo>");  
	   out.println("\n\t\t<DateOfTransaction>" + t.getDateOfTransaction() + "</DateOfTransaction>");
	   out.println("\n\t\t<ToAccount>"+t.getToAccount()+"</ToAccount>");
       out.println("\n\t\t<Amount> " + t.getAmount() +"</Amount>");  
	   out.println("\n\t\t<Balance>" + t.getBalance() + "</Balance>");
	   out.println("\n\t\t<Description>" + t.getDescription() + "</Description>");        
	   out.println("\n\t</Transaction>");  
	        }  
	  out.println("</Transactions>");  
	   
	  out.close();   
	 }
	  
	 } 
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  
{  
 doGet(req, resp);  
}  
}  


