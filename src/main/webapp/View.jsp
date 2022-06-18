<%@page import="java.util.ArrayList"%>
<%@page import="com.billing.entity.Cdata"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer's Data</h2>
	<table>
		<tr>
			<td>name</td>
			<td>meter_no</td>
			<td>address</td>
			<td>state</td>
			<td>city</td>
			<td>phone_no</td>
		</tr>
		<%
		List<Cdata> list = (ArrayList<Cdata>) request.getAttribute("see");
		%>
		<%
		for (Cdata c : list) {
		%>
		<tr>
			<td><%=c.getName()%></td>
			<td><%=c.getMeter_no()%></td>
			<td><%=c.getAddress()%></td>
			<td><%=c.getState()%></td>
			<td><%=c.getCity()%></td>
			<td><%=c.getPhone_no()%></td>

		</tr>

		<%
		}
		%>
	</table>

</body>
</html>