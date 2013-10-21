package com.OMBAdatabase.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import com.OMBAdatabase.LoginServlet;
import com.OMBAdatabase.DaoFiles.UserDao;
import com.OMBAdatabase.ItemFiles.SecurityQuestion;
import com.OMBAdatabase.ItemFiles.User;


@SuppressWarnings("serial")
public class AddSecurityQuestion extends HttpServlet {
	
	int flag=0;
	String message="";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		    resp.setContentType("text/html");
		    if(LoginServlet.login==1){ 
			String customerId= checkCustomerId(req.getParameter("customerId"));
			String[] ques=req.getParameterValues("question");
			String ans=req.getParameter("answer");
			List<SecurityQuestion> sq= new ArrayList<SecurityQuestion>();
			List<SecurityQuestion> q= new ArrayList<SecurityQuestion>();
			
        	List<User> c=UserDao.INSTANCE.listCustomers();
            int cc=0;
        if(flag==0){  	
        	for(User cus:c){
        		if((cus.getCustomerId()).equals(customerId)){
        			cc=1;
        			if(ans!=null){
        				    q=cus.getSQ();
        				    for(SecurityQuestion j:q){
        				    	sq.add(new SecurityQuestion(j.getQuestionId(),j.getAnswer()));
        				    }        					
        					sq.add(new SecurityQuestion(ques[0],ans));
                            UserDao.INSTANCE.updateSQ(cus.getId(),sq);
          			       resp.getWriter().println("Selected question and answer are added");        				
        			}
        			else resp.getWriter().println("Please enter an answer");
        		}
        	}
        	if(cc==0)
        	resp.getWriter().println("Customer id does not exist");
        }  

        else
        {
        	String[] msg1=message.split(",");
        	for(String m1:msg1)
        	{
        		resp.getWriter().println(m1);
        	}
        }
      } else resp.sendRedirect("/JSPfiles/AdminLogin.jsp");
    }

	String checkCustomerId(String s) 
	{
			if (s!=null && s.matches("\\d{8}")) 
			{
				return s;
			}
			else
			{
				flag=1;
				message+=("invalid customerId,");
			}
			
			return "";
	}
	
}
		
