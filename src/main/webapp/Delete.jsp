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
<h1>Delete data</h1>
<form action="hit" method ="get">
<table>
<tr>
<td>Enter meter_no which information want to delete:</td>
<td><input type="number" name="user_meterno" pattern="[0-9]{5}" placeholder= "*****"></td>
</tr>

  
   <td>
            <button type="submit" value="delete" name="hit">Register</button>
            <button type="reset">Reset</button>
 </td>
</table>
</form>
</div>
</body>
</html>