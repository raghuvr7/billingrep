<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style>            
body{margin-right: 10%;margin-left: 10%;} 
.left{width:30%;height:50%;background-color: grey;position:relative;margin-top:20%;text-align: center;float:left;}
.right{position:relative;width:60%;height:50%;float:right;margin-top: 2%;}		
table{text-align: left;	width: 100%;}
.unline{border-bottom: thin;border-bottom-style: dotted;}        
</style> 
</head>
<body>
<h1>Bill</h1>        
 <hr>        
 <div class="left">                        
 verizon.com<br>
 Shop*Bill PAy*Account Change<br>                        
Auto pay*Paper Free Bill* Repair<br>
<br>Go green today-Go Paper Free@<br>
verizon.com/myverizon
</div>
<div class="right">		
<table>			
<tr>
<th>Account Number</th>
<th>Due Date</th>
<th>Amount Due</th>
</tr>		
<c:forEach var="c" items="${payment}">
<tr>
<th><h3><c:out value="${c.custID}"></c:out></h3></th>
<th><c:out value="${c.billed_date}"></c:out></th>
<th><c:out value="${c.current_due}"></c:out></th>

</tr>	
</c:forEach>
<tr>			
<td>
<h3><br/>Account Information</h3></td>		</tr>
<tr><td><b>Statement Date:<%= new java.util.Date() %> </b></td>	</tr>
<c:forEach var="d" items="${custinfo}">
<tr><td><b><c:out value="${d.cust_name}"></c:out></b></td></tr>		
<tr><td><b><c:out value="${d.cust_mobile_no}"></c:out></b></td></tr>	
</c:forEach>	<tr></tr><tr></tr><tr></tr><tr></tr>
<tr><td><b>Account Summary</b></td></tr>	
<tr><td colspan="2" class="unline">Previous Balance</td>
<c:forEach var="z" items="${previous}">
<td class="unline"><c:out value="${z.previous_balance}"></c:out></td></c:forEach></tr>	

<c:forEach var="p" items="${previous}">
	
<tr><td colspan="2" class="unline">Payment Received</td>
<td class="unline"> <c:out value="${p.paid_amount}"></c:out>  </td></tr>		
<tr><td colspan="2" class="unline">Adjustments and Credits</td>
<td class="unline">No credits</td></tr>	
</c:forEach>		
<c:forEach var="p1" items="${payment}">
<tr><td colspan="2" >Credit Balance</td><td><c:out value="${p1.credit_balance}"></c:out></td></tr>
</c:forEach>
<tr><td colspan="2"><br/><font color="red"><b>New Charges</b></font></td></tr>
<c:forEach var="e" items="${payment}">
<tr><td colspan="2" class="unline">Current Activity</td>
<td class="unline"><c:out value="${e.current_activity}"></c:out></td></tr>	
</c:forEach>

<c:forEach var="t" items="${tp}">
<tr><td colspan="2" class="unline">Specials and Promotions</td>
<td class="unline"><c:out value="${t.promotions}"></c:out></td></tr>		<tr><td colspan="2" class="unline">Taxes Fees and Other Charges</td>
<td class="unline"><c:out value="${t.tax}"></c:out></td></tr>
</c:forEach>
<c:forEach var="e" items="${payment}">
<tr><td colspan="2"><b>Total</b> </td><td><b><c:out value="${e.billed_amount}"></c:out></b></td></tr>
</c:forEach>
<c:forEach var="p" items="${payment}">
<tr><th colspan="2">Total New Charges due by
<c:out value="${p.billed_date}"></c:out></th>
<td> <c:out value="${p.newchargesby}"></c:out>  </td></tr>
</c:forEach>


<c:forEach var="p" items="${payment}">
<tr><th colspan="2">Payment Received</th>
<td> <c:out value="${p.paid_amount}"></c:out>  </td></tr>
</c:forEach>
<c:forEach var="e" items="${payment}">
<tr><td colspan="2"><h3>Amount Due by <c:out value="${e.billed_date}"></c:out></h3></td>
<td><b><c:out value="${e.current_due}"></c:out></b></td></tr>		
</c:forEach>
</table>    
</div>
<div class="right">
<table>
<tr>
<td><b><font color="red"> Product Break Down</font></b></td>
</tr>
<tr>
<th>Product Name</th>
<th>Product Start Date</th>
<th>Product End Date</th>
<th>Quantity</th>
<th>Amount</th></tr>
<c:forEach var="f" items="${invoicebreakup}">
<tr>
<td align="center"><c:out value="${f.ps_desc}"></c:out></td>
<td align="center"><c:out value="${f.chargeStartDate}"></c:out></td>
<td align="center"><c:out value="${f.chargeEndDate}"></c:out></td>
<td align="center"><c:out value="${f.ps_quantity}"></c:out></td>
<td align="center"><c:out value="${f.product_amount}"></c:out></td></tr>
</c:forEach>
<c:forEach var="e" items="${payment}">
<tr>
<td colspan="2"><h3>Total Charges on  :<c:out value="${e.billed_date}"></c:out></h3></td>
<td></td>
<td></td>
<th><b><c:out value="${e.current_activity}"></c:out></b></th></tr>
</c:forEach>
</table>
</div>
</body>
</html>