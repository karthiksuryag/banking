<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.OMBAdatabase.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title> OMBA Admin Login</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css"/>
</head>

<body topmargin="3" marginheight="3">
<center><br><br><br><br><br>
<h1><b>OMBA</b></h1>
<h2>Online and Mobile Banking Application</h2>
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
    
    <h3>Welcome Admin!</h3><br>
    <a href="Menu.jsp">Menu</a><br>
	<form method="get" action="/Logout">
	<table><tr><td>
	        <input type="submit" value="Logout" />
	       </td></tr>
	</table>
	</form>
<% } %>

</center>

</body>
</html>

			