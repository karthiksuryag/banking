package com.OMBAdatabase;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  
	{  
		LoginServlet.login=0;
		resp.sendRedirect("/JSPfiles/AdminLogin.jsp");
	} 
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  
	{
		doGet(req,resp);
	}
}
