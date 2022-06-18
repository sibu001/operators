<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile page</title>
</head>
<body>
	<div class="container">
		<h1>customer profile</h1>
		<form action="operation" method="get">
			<table>
				<tr>
					<td>Enter customer name:</td>
					<td><input type="text" name="user_name"
						placeholder="Enter here"></td>
				</tr>
				<tr>
					<td>Enter customer meter_no:</td>
					<td><input type="number" name="user_meter" pattern="[0-9]{5}"
						placeholder="*****"></td>
				</tr>
				<tr>
					<td>Enter customer address:</td>
					<td><input type="text" name="address" placeholder="Enter here"></td>
				</tr>
				<tr>
					<td>Enter customer State:</td>
					<td><input type="text" name="user_state"
						placeholder="Enter here"></td>
				</tr>
				<tr>
					<td>Enter customer city:</td>
					<td><input type="text" name="user_city"
						placeholder="Enter here"></td>
				</tr>
				<tr>
					<td>Enter your phone number:</td>
					<td><input type="tel" id="phone" name="phone"
						pattern="[0-9]{2}-[0-9]{10}" placeholder="91-**********">
					</td>
				</tr>
				<td>
				</td>

				<td>
					<button type="submit" value="insert" name="operation">Register</button>
					<button type="reset">Reset</button>
				</td>
			</table>
		</form>
	</div>
</body>
</html>