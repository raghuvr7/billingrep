<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet" href="theme.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Bill info</title>
</head>
<body > 
<% Integer fooParameter =(Integer) request.getAttribute( "l1" ); %>
<pre>Customer information:                                                               Date:
Customer id=<%=fooParameter%>                                                                    <%= new java.util.Date() %>
 </pre><br/><br/>
<center>

<table  class="vztable"> 
<tr> 
<td>Bill<td>Customer ID<td>Invoice id<td>Amount paid<td>Bill date<td>View bill
</tr>
<%int i=1 ;%>
<c:forEach var="c" items="${l}">
  <tr> 
  <td>Bill<%=i %> </td>
  <%i=i+1 ;%>
  
	<td><c:out value="${c.id}"></c:out>   </td>
	<td><c:out value="${c.invoiceid}"></c:out></td>
	<td><c:out value="${c.amountpaid}"></c:out>
	<td><c:out value="${c.date}"></c:out> </td>
	<!-- <td><input type="submit" value="View bill" onclick="javascript:viewing(c.id,c.date)" /> -->
	<td> <a href="BillController?V1=${c.id}&V2=${c.invoiceid}">View Bill</a></td>
</tr>
</c:forEach> 
</table>
</center>

</body>
</html>