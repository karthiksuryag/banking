<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.OMBAdatabase.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Accounts</title>
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
<h2>Add Account</h2>
</center><hr />
<form method="get" action="/Logout">
	<table><tr><td>
	        <input type="submit" value="Logout" />
	       </td></tr>
	</table>
	</form>
<br>
<a href="/AccountViewXml">View XML</a>
&nbsp;&nbsp;<a href="Menu.jsp">Menu</a>
<br>
 <form action="/newAccount" method="get" enctype="multipart/form-data">  
 <table >  
     <tr>  
       <td><label>Account Number</label> </td>  
       <td >
       <input size="35" type="text" name="accountNo" id="accountNo"></td>  
    </tr>  
    <tr>  
       <td><label>Customer ID</label></td>
       <td ><input size="35" type="text" name="customerId" id="customerId"></td>     
    </tr>  
    <tr>  
       <td><label>Balance</label></td>
       <td ><div><input size="35" type="text" name="balance" id="balance"></div></td>      
    </tr>  
    <tr>  
     <td><label>Last statement date</label></td>  
     <td >  
        <select name="LstatDate1" id="LstatDate1">
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
         
        <select name="LstatDate2" id="LstatDate2" >
        	<option selected>01</option><option>02</option><option>03</option>
           	<option>04</option><option>05</option><option>06</option>
            <option>07</option><option>08</option><option>09</option>
            <option>10</option><option>11</option><option>12</option>      
        </select> 
        
        <input type="text" id="LstatDate3" name="LstatDate3" size="4"/>  
    </tr>  
    
    
    <tr>  
     <td><label>Last transaction date</label></td>  
     <td >  
        <select name="LtransDate1" id="LtransDate1">
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
         
        <select name="LtransDate2" id="LtransDate2" >
        	<option selected>01</option><option>02</option><option>03</option>
           	<option>04</option><option>05</option><option>06</option>
            <option>07</option><option>08</option><option>09</option>
            <option>10</option><option>11</option><option>12</option>      
        </select> 
        
        <input type="text" id="LtransDate3" name="LtransDate3" size="4"/>
     </td>  
    </tr>       
    
     <tr>  
     <td><label>Date of Creation</label></td>  
     <td >  
        <select name="CDate1" id="CDate1">
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
         
        <select name="CDate2" id="CDate2" >
        	<option selected>01</option><option>02</option><option>03</option>
           	<option>04</option><option>05</option><option>06</option>
            <option>07</option><option>08</option><option>09</option>
            <option>10</option><option>11</option><option>12</option>      
        </select> 
        
        <input type="text" id="CDate3" name="CDate3" size="4"/>
     </td>  
    </tr>  
    <tr>  
  <td colspan=100%><input type="submit" value="SUBMIT" /></td>  
    </tr> 
     
 </table>  
 </form> 

  <% }%>

</body>  
</html> 