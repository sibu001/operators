<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>customer update</h1>
<form action="hit" method ="get">
<table>
<tr>
<td>Enter meter_no want to update:</td>
<td><input type="number" name="user_meterno" pattern="[0-9]{5}" placeholder= "enter 5 digit meter_no"></td>
</tr>
 <tr>
             <td>Enter updated name:</td>
             <td><input type="text" name= "user_name"  placeholder= "Enter here"></td>
  </tr>
  <tr>
             <td>Enter updated customer address:</td>
             <td><input type="text" name= "address" placeholder= "Enter here"></td>
  </tr>
   <tr>
             <td>Enter updated customer State:</td>
             <td><input type="text" name= "user_state" placeholder= "Enter here"></td>
  </tr>
   <tr>
             <td>Enter updated customer city:</td>
             <td><input type="text" name= "user_city" placeholder= "Enter here"></td>
  </tr>
   <tr>
             <td>Enter updated customer phone No.:</td>
             <td><input type="tel"  name="phone" pattern="[0-9]{10}" placeholder="enter 10 digit">
             </td>
  </tr>
  <td>
  
  </td>
  
   <td>
            <button type="submit" value="update" name="hit">Register</button>
            <button type="reset">Reset</button>
 </td>
</table>
</form>
</div>
</body>
</html>