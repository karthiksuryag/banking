<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.OMBAdatabase.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>New Customer</title>
		<link rel="stylesheet" type="text/css" href="CSS/style.css"/> 
	</head>
	<body>
	
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

<center>
	<h1><b>OMBA</b></h1>
<br>
<br>
<h2>Add Customer</h2>
</center>
<hr />
<form method="get" action="/Logout">
	<table><tr><td>
	        <input type="submit" value="Logout" />
	       </td></tr>
	</table>
</form><br>
<a href="/CustomerViewXml">View XML</a>
&nbsp;&nbsp;<a href="Menu.jsp">Menu</a>
<br>
<form action="/newCustomer" method="get" enctype="multipart/form-data">
	<table>
		<tr>
		    <td valign="top"><label>Name</label></td>
		    <td><input type="text" name="name" id="name" size="65" /></td>
	    </tr>
		<tr>
			<td><label>Date of Birth</label></td>
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
			<td><label>Customer id</label></td>
			<td><input type="text" name="customerId" id="customerId" size="8"/></td>
		</tr>
	    <tr>
			<td><label>Mobile Number</label></td>
			<td><input type="text" name="mobileNo" id="mobileNo" size="12"/></td>
		</tr>
	    <tr>
			<td><label>Permanent Address</label></td>
			<td><textarea rows=7 name="permanentAddress" id="permanentAddress"></textarea><br><br></td>
		</tr>
	    <tr>
			<td><label>Current Address</label></td>
			<td><textarea rows=7 name="currentAddress" id="currentAddress"></textarea><br><br></td>
		</tr>
		<tr>
			<td><label>Name of Father</label></td>
			<td><input type="text" name="fathersName" id="fathersName" size="65"/></td>
		</tr>
		<tr>
			<td><label>Nationality</label></td>
			<td><select name="nationality" id="nationality" size=4>
			    <option selected>--Select Nationality--</option>
			    <option>India</option>
			    <option>Malaysia</option>
			    <option>Philippines</option>
			    <option>USA</option>
			</select><br></td>
		</tr>
		<tr>
			<td><label>Sex</label></td>
			<td><input type="radio" name="sex" id="sex" value="Male" checked/> Male
                <input type="radio" name="sex" id="sex" value="Female" /> Female<br>
            </td>
		</tr>
		<tr>
			<td><label>Occupation</label></td>
			<td><input type="radio" name="occupation" id="occupation" value="student" checked/>Student 
                <input type="radio" name="occupation" id="occupation" value="service"/> Service
                <input type="radio" name="occupation" id="occupation" value="selfemployed"/> Self Employed 
                <input type="radio" name="occupation" id="occupation" value="professional"/> Professional<br>  
                <input type="radio" name="occupation" id="occupation" value="business"/> Business
                <input type="radio" name="occupation" id="occupation" value="agriculture"/> Agriculture
                <input type="radio" name="occupation" id="occupation" value="labor"/> Labor
                <input type="radio" name="occupation" id="occupation" value="other"/> Other
                <input type="radio" name="occupation" id="occupation" value="none"/> None                
            </td>
		</tr>
		<tr>
			<td><label>Annual Income</label></td>
			<td><input type="text" name="annualIncome" id="annualIncome" size="10"/></td>
		</tr>
		<tr>
			<td><label>Email Address</label></td>
			<td><input type="text" name="emailAddress" id="emailAddress" size="65"/></td>
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input type="password" name="password" id="password" size="25"/></td>
		</tr>
		<tr>
			<td><label>Re-enter Password</label></td>
			<td><input type="password" name="rePassword" id="rePassword" size="25"/></td>
		</tr>
		<tr>
	  		<td> <label>Select a Question</label> </td>
	  		<td><select id="question" name="question">
	   			<option value="1" selected>What is your mother's maiden name?</option>
	  			 <option value="2">What is your pet's name?</option>
	   			<option value="3">What is your first school'€™s name?</option>
	  			 <option value="4">Who is your favorite teacher?</option>
	  			 <option value="5">What is your street name?</option>
	   			</select>
	   		</td>
		</tr>
	<tr>
	  <td> <label>Answer</label></td>
	  <td> <input type="text" id="answer" name="answer" size="65"/></td>
	</tr>
	    <tr>
			<td colspan="2" align="center"><br><input type="submit" value="Next"/></td>
		</tr>
	</table>
</form>
<%}  %>


</body>
</html>