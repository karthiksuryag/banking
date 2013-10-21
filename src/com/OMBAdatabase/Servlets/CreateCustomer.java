package com.OMBAdatabase.Servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OMBAdatabase.LoginServlet;
import com.OMBAdatabase.DaoFiles.*; 
import com.OMBAdatabase.ItemFiles.SecurityQuestion;
import com.OMBAdatabase.ItemFiles.User;

@SuppressWarnings("serial")
public class CreateCustomer extends HttpServlet {

	int flag;
	String message;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		flag=0;
		message="Errors: ,";
		
		resp.setContentType("text/html");
		if(LoginServlet.login==1){ 
		resp.getWriter().println("<h3>Creating new customer</h3><br>");

		String name = checkName((String)(req.getParameter("name")));
		String dot1= req.getParameter("dot1");
		String dot2=req.getParameter("dot2");
		String dot3= checkDob(req.getParameter("dot3"));
		String customerId = checkcustomerId((String)(req.getParameter("customerId")));
		String mobileNo = checkMobileNo((String)(req.getParameter("mobileNo")));
		String permanentAddress = checkNull((String)(req.getParameter("permanentAddress")));
		String currentAddress = ((String)(req.getParameter("currentAddress")));
		String fathersName = checkName((String)(req.getParameter("fathersName")));
		String nationality = checkNationality(req.getParameter("nationality"));
		String sex = (req.getParameter("sex"));
		String occupation = checkNull(req.getParameter("occupation"));
		String annualIncome = checkAnnualIncome((String)(req.getParameter("annualIncome")));
		String emailAddress = checkEmailAddress((String)(req.getParameter("emailAddress")));
		String rePassword = ((String)(req.getParameter("rePassword")));
		String password = checkPassword((String)(req.getParameter("password")),rePassword);
	    String[] question = (req.getParameterValues("question"));
		String answer = checkNull((String)(req.getParameter("answer")));		
	
		if(flag==0){

			CustomerDao.INSTANCE.add(name,dot1+"-"+dot2+"-"+dot3,customerId,mobileNo,
				permanentAddress,currentAddress,fathersName,nationality,sex,occupation,
				annualIncome,emailAddress);
     		resp.getWriter().println("New Customer is added");
     		List<SecurityQuestion> sq=Arrays.asList(new SecurityQuestion(question[0],answer));
     		UserDao.INSTANCE.add(customerId,password,sq);
		}
		else{
			
			 String[] mesg=message.split(",");
			 resp.getWriter().println("<center><br><br>");
			 for(String m:mesg){
			        resp.getWriter().println("Error: "+m+"<br>");
			 }
			 resp.getWriter().println("</center>");
		}
		} else resp.sendRedirect("/JSPfiles/AdminLogin.jsp");
	}

	private String checkNull(String s) {
		if (s == null) {
			flag=1;
			message+=(",Required field is null");
			return "";
		}
		return s;
	  }
	
	private String checkName(String s) {
		if (s != null && s.matches("^[a-zA-Z ]+$")) {
			return s.toUpperCase();
		}
		else{
			flag=1;
		}
		message+=",Name should contain only characters";
		return "";
	}
	private String checkDob(String s) {
		if (s != null && s.matches("19\\d{2}")) {
			return s;
		}
		else{
			flag=1;
		}
		message+=", Unacceptable year";
		return "";
	}
	private String checkcustomerId(String s) {
		if (s != null && s.matches("\\d{8}") ) {
			List<User> c=UserDao.INSTANCE.listCustomers();
	           
	       
	        	for(User cus:c){
	        		if((cus.getCustomerId()).equals(s)){
	        		  flag=1;
	        		  message+=",customer id already exists";
	        		  return "";
	        		}
	        		
	        	}
	        			return s;
		}
		else{
			flag=1;
		}
		message+=",Customer id should contain 8 digits";
		return "";
	}
	
	private String checkMobileNo(String s) {
		if (s != null && s.matches("\\d{12}")) {
			return s;
		}
		else{
			flag=1;
		}
		message+=",Mobile Number should contain 12 digits";
		return "";
	}
	private String checkNationality(String s) {
		if (s != null && s!="--Select Nationality--") {
			return s;
		}
		else{
			flag=1;
		}
		message+=",Nationality not selected";
		return "";
	}
	private String checkAnnualIncome(String s) {
		if (s != null && s.matches("^[1-9]\\d*(\\.\\d+)?$")) {
			return s;
		}
		else{
			flag=1;
		}
		message+=",Annual income is a decimal";
		return "";
	}
	private String checkEmailAddress(String s) {
		if (s != null && s.matches("^[a-zA-Z]\\w*[\\._]*\\w*@[a-z]*.[a-z]*")) {
			return s;
		}
		else{
			flag=1;
		}
		message+=",Improper Email address";
		return "";
	}
	private String checkPassword(String p,String s) {
		if (s != null && s.matches("^[a-zA-Z]\\w*[\\.@$!_]*\\w*")) {
			if(s.equals(p))
				return s;
			else {
				flag=1;
				message+=",Password mismatch";
			}
		}
		else{
			flag=1;
		}
		message+=",Password can contain alphanumerics and any of \'.@_$\'";
		return "";
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  
	 {  
	  doGet(req, resp);  
	 } 
}
