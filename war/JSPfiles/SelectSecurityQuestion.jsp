<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.OMBAdatabase.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Select Security Question</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css"/>
</head>

<body topmargin="3" marginheight="3">
<center><br><br>
<h1><b>OMBA</b></h1>
<br>

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

<h2>Add Security Question</h2></center>
<hr />
<form method="get" action="/Logout">
	<table><tr><td>
	        <input type="submit" value="Logout" />
	       </td></tr>
	</table>
</form><br>
&nbsp;<a href="Menu.jsp">Menu</a>
<br>
	<form action="/newSecurityQuestion" method="get">
	<table>
	<tr>
	  <td> <label>Customer id</label></td>
	  <td> <input type="text" id="customerId" name="customerId" size="8"/></td>
	</tr>
	<tr>
	  <td> <label>Select a Question</label> </td>
	  <td><select id="question" name="question">
	   <option value="1" selected>What is your mother's maiden name?</option>
	   <option value="2">What is your pet's name?</option>
	   <option value="3">What is your first school'€™s name?</option>
	   <option value="4">Who is your favorite teacher?</option>
	   <option value="5">What is your street name?</option>
	   </select></td>
	</tr>
	<tr>
	  <td> <label>Answer</label></td>
	  <td> <input type="text" id="answer" name="answer" size="65"/></td>
	</tr>
	<tr>
	<td  colspan="2" align="center"><input type="submit" value="Submit"/></td>
	</tr>
	</table>
	</form>
<%} %>

</body>
</html>