<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.OMBAdatabase.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title> OMBA Menu</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css"/>
</head>

<body topmargin="3" marginheight="3">
<center><br><br>
<h1><b>OMBA</b></h1>

<% 

String urlLinktext = "Login";
if (LoginServlet.login==0){
	
%> 
<form method="get" action="/Login">  
 <table>
    <tr><td><label>Username:</label></td>
        <td><input type="text" name="username" /></td>
    </tr>
    <tr><td><label>Password:</label></td>
        <td><input type="password" name="password"/></td>
    </tr>
    <tr><td colspan="2">
            <input type="submit" value="Login" /></td>
    </tr>
 </table>
</form>
<%}
else{ %>
    <h3>Menu</h3><br>
	<form method="get" action="/Logout">
	<table><tr><td>
	        <input type="submit" value="Logout" />
	       </td></tr>
	</table>
	</form><br>
	
	  <table>
	  <tr>
	  <td><a href="AddCustomer.jsp" class="b">Add Customer</a></td>
	  <td><a href="/CustomerViewXml" class="b">View XML</a></td></tr>	   
	  <tr><td> <a href="AddAccount.jsp" class="b">Add Account</a></td>
	  <td><a href="/AccountViewXml" class="b">View XML</a></td></tr>
	  <tr><td> <a href="AddBeneficiary.jsp" class="b">Add Beneficiary</a></td>
	  <td><a href="/BeneficiaryViewXml" class="b">View XML</a></td></tr>
	  <tr><td> <a href="AddTransaction.jsp" class="b">New Transaction</a></td>
	  <td><a href="/TransactionViewXml" class="b">View XML</a></td></tr>
      <tr><td> <a href="SelectSecurityQuestion.jsp" class="b">Add Security Question</a></td>
      <td><a href="/LoginDetailsViewXml" class="b">View Login Details XML</a></td></tr>	  
	  </table>
	  
<%} %>

</center>
</body>
</html>