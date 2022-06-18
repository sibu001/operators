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
		<h1>login admin</h1>
		<form action="login" method="post">
			<table>
				<tr>
					<td>Enter user_name:</td>
					<td><input type="text" name="user_name"
						placeholder="Enter here"></td>
				</tr>
				<tr>
					<td>Enter password:</td>
					<td><input type="password" name="user_password"
						placeholder="Enter here"></td>
				</tr>

				<td>
					<button type="submit" value="loggin" name="login">Login</button>
					<button type="reset">Reset</button>
				</td>

			</table>
		</form>
	</div>
</body>
</html>
