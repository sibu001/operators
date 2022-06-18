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
		<h1>pay bill</h1>
		<form action="operation" method="get">
			<table>
				<tr>
					<td>Enter valid month of bill :</td>
					<td><input type="date" name="user_month"
						placeholder="Enter here"></td>
				</tr>
				<tr>
					<td>Enter customer meter_no:</td>
					<td><input type="number" name="user_meterno" 
						placeholder="*****"></td>
				</tr>
				<tr>
					<td>Enter unit consumed:</td>
					<td><input type="number" name="unit" placeholder="Enter here"></td>
				</tr>



				<td></td>

				<td>
					<button type="submit" value="pay" name="operation">Register</button>
					<button type="reset">Reset</button>
				</td>
			</table>
		</form>
	</div>
</body>
</html>
