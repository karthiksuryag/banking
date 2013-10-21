package com.OMBAdatabase.XMLservlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OMBAdatabase.LoginServlet;
import com.OMBAdatabase.DaoFiles.UserDao;
import com.OMBAdatabase.ItemFiles.SecurityQuestion;
import com.OMBAdatabase.ItemFiles.User;

@SuppressWarnings("serial")
public class DisplayLoginDetailsXML extends HttpServlet    
{ 

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  
	{  
		
		resp.setContentType("text/xml");
		if(LoginServlet.login==1){ 
		PrintWriter out=resp.getWriter(); 
		
		List<User> customers = UserDao.INSTANCE.listCustomers();
		 
		//loop through items list and print each item 
		out.println("<LoginData>");
		for (User c:customers)  
	        {  
				out.println("\n\t<Customer>");
				out.println("\n\t\t<CustomerId>"+c.getCustomerId()+"</CustomerId>");
				out.println("\n\t\t<Password>"+c.getPassword()+"</Password>");
				out.println("\n\t\t<SecurityQuestion>");
				List<SecurityQuestion> uu = c.getSQ();
				   int count = 1;
				   for(SecurityQuestion qq : uu)
				   {
					   out.println("\n\t\t\t<Question"+count+">");
					   out.println("\n\t\t\t\t<Question>" + qq.getQuestionId() + "</Question>");
					   out.println("\n\t\t\t\t<Answer>" + qq.getAnswer() + "</Answer>");
					   out.println("\n\t\t\t</Question"+count+">");
					   count++;
				   }
				   
				   out.println("\n\t\t</SecurityQuestion>");
				out.println("\n\t</Customer>");  
	        }  
		out.println("</LoginData>");  
		
		out.close();  
		}  
	 } 
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  
	{  
		doGet(req, resp);  
	}  
}  
