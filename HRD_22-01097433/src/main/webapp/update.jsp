<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.MemberDto"%>
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
	request.setCharacterEncoding("UTF-8");
	int custno = Integer.parseInt(request.getParameter("custno"));
	MemberDao memberDao = MemberDao.getInstance();
	MemberDto member = memberDao.getMember(custno);
	String grade = member.getGrade();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(member.getJoindate());
%>
<div class="container">
<jsp:include page="header.jsp" />
<section>
	<div class="table_box">
	<h1>홈쇼핑 회원 정보 수정</h1>
	<form method="POST" action="updatePro.jsp">
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td><input type="text" id="custno" name="custno" value="<%=custno%>" readonly /></td>
		</tr>
		<tr>
			<td>회원성명</td>
			<td><input type="text" id="custname" name="custname" value="<%=member.getCustname() %>" required /></td>
		</tr>
		<tr>
			<td>회원전화</td>
			<td><input type="text" id="phone" name="phone" value="<%=member.getPhone() %>" required /></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" id="address" name="address" value="<%=member.getAddress() %>"  required /></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td><input type="date" id="joindate" name="joindate" value="<%=date %>"  required /></td>
		</tr>
		<tr>
			<td>고객등급</td>
			<td>
				<select id="grade" name="grade" >
					<option value="A" <%=grade.equals("A") ? "selected" : "" %>>VIP</option>
					<option value="B" <%=grade.equals("B") ? "selected" : "" %>>일반</option>
					<option value="C" <%=grade.equals("C") ? "selected" : "" %>>직원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>도시코드</td>
			<td><input type="text" id="city" name="city"   value="<%=member.getCity()%>"  required /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" />
				<input type="button" value="조회" />
			</td>
		</tr>
	</table>
	</form>
	</div>
</section>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>