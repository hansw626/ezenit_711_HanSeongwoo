<%@page import="money.MoneyDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="money.MoneyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="basic.css"/>
</head>
<body>
<% 
MoneyDao moneyDao = MoneyDao.getInstance();
ArrayList<String[]> salesList = moneyDao.getSalebyMember();
%>
<div class="container">
	<jsp:include page="header.jsp" />
	<section>
		<h2>회원매출조회</h2>
		<table border="1">
			<thead>
				<tr>
					<td>회원번호</td>
					<td>회원성명</td>
					<td>고객등급</td>
					<td>매출</td>
				</tr>
			</thead>
			<tbody>
			<%for(String[] sales : salesList){ %>
				<tr>
					<td><%=sales[0] %></td>
					<td><%=sales[1] %></td>
					<td><%=sales[2] %></td>
					<td><%=sales[3] %></td>
				</tr>
			<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>