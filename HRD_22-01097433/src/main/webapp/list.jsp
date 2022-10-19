<%@page import="member.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDao"%>
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
MemberDao memberDao = MemberDao.getInstance();
ArrayList<MemberDto> memberList = memberDao.getMemberAll();
%>
<div class="container">
	<jsp:include page="header.jsp" />
	<section>
		<h2>회원목록조회/수정</h2>
		<table border="1">
			<thead>
				<tr>
					<td>회원번호</td>
					<td>회원성명</td>
					<td>전화번호</td>
					<td>주소</td>
					<td>가입일자</td>
					<td>고객등급</td>
					<td>거주지역</td>
				</tr>
			</thead>
			<tbody>
			<%for(MemberDto member : memberList){ %>
				<tr>
					<td><a href="update.jsp?custno=<%=member.getCustno()%>" 
						style="text-decoration:none; color:#aaa"><%=member.getCustno()%></a></td>
					<td><%=member.getCustname()%></td>
					<td><%=member.getPhone()%></td>
					<td><%=member.getAddress()%></td>
					<td><%=memberDao.getJoindate(member.getJoindate())%></td>
					<td><%=member.getGrade()%></td>
					<td><%=member.getCity()%></td>
				</tr>
			<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>