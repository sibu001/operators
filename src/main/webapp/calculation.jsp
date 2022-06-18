<%@page import="com.billing.entity.Billdata"%>
<%@page import="com.billing.entity.Cdata"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>bill generate</h2>
	<table>
		<tr>
			<%
			Cdata c = (Cdata) request.getAttribute("billing");
			Billdata bd = (Billdata) request.getAttribute("invoice");
			%>
			<td>name:</td>
			<td><%=c.getName()%></td>
		<tr>
			<td>meter_no:</td>
			<td><%=c.getMeter_no()%></td>
		</tr>
		<tr>
			<td>address:</td>
			<td><%=c.getAddress() %></td>
		</tr>	
		<tr>
			<td>state:</td>
			<td><%=c.getState() %></td>
		</tr>	
		<tr>
			<td>city:</td>
			<td><%=c.getCity() %></td>
		</tr>	
		<tr>
			<td>phone:</td>
			<td><%=c.getPhone_no() %></td>
		</tr>	
		<tr>
		<td>
		<h3>Total amount you have to pay is Rs:</h3>
		</td> 
		<td>
		<%=bd.getAmount() %>
		</td>
		</tr>	







		
	</table>
</body>
</html>