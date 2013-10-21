<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.OMBAdatabase.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ page import="java.util.ArrayList" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Transactions</title>
		<link rel="stylesheet" type="text/css" href="CSS/style.css"/>
</head>
<body>
<center>
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

<br>
<h2>New Transaction</h2>
</center><hr />
<form method="get" action="/Logout">
	<table><tr><td>
	        <input type="submit" value="Logout" />
	       </td></tr>
	</table>
</form>
<br>
<a href="/TransactionViewXml">View XML</a>
&nbsp;&nbsp;<a href="Menu.jsp">Menu</a>
<br>
<form action="/newTransaction" method="get" accept-charset="utf-8">
	<table>
	
		<tr>
			<td><label>Customer id</label></td>
			<td><input type="text" name="customerId" id="customerId" size="8"/></td>
		</tr>
		
		<tr>
			<td><label>Account Number</label></td>
			<td><input type="text" name="accountNo" id="accountNo" size="12"/></td>
		</tr>
	   <tr>
			<td><label >Date of Transaction</label></td>
			<td >  
			<select name="dot1" id="dot1">
        	<option selected>01</option><option>02</option><option>03</option>
           	<option>04</option><option>05</option><option>06</option>
            <option>07</option><option>08</option><option>09</option>
            <option>10</option><option>11</option><option>12</option>
            <option>13</option><option>14</option><option>15</option>
           	<option>16</option><option>17</option><option>18</option>
            <option>19</option><option>20</option><option>21</option>
            <option>22</option><option>23</option><option>24</option>
            <option>25</option><option>26</option><option>27</option>
           	<option>28</option><option>29</option><option>30</option>
            <option>31</option>
        </select>
        <select name="dot2" id="dot2" >
        	<option selected>01</option><option>02</option><option>03</option>
           	<option>04</option><option>05</option><option>06</option>
            <option>07</option><option>08</option><option>09</option>
            <option>10</option><option>11</option><option>12</option>      
        </select>
        <input type="text" id="dot3" name="dot3" size="4"/>
     </td>  
		</tr>
	  <tr>
	     <td><label >Time of Transaction</label></td>
		 <td><input type="text" id="time" name="time" size="8"/></td>  
	  </tr>
		<tr>
			<td><label>To account</label></td>
			<td><input type="text" name="toAccount" id="toAccount" size="12"/></td>
		</tr>
		<tr>
			<td><label>Amount</label></td>
			<td><input type="text" name="amount" id="amount" size="15"/></td>
		</tr>
		<tr>
			<td><label>Balance</label></td>
			<td><input type="text" name="balance" id="balance" size="15"/></td>
		</tr>
		<tr>
			<td><label>Description</label></td>
			<td><input type="text" name="description" id="description" size="45"/></td>
		</tr>
	<tr><td colspan="2" align="center"><input type="submit" value="Create new transaction"/></td>
	</tr>
	</table>
</form>
<% } %>

</body>
</html>
