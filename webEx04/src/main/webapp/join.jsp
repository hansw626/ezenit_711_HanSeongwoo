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
int custno = memberDao.getNewCustno();
%>
<div class="container">
	<jsp:include page="header.jsp" />
	<section>
		<h2>홈쇼핑 회원 등록</h2>
		<form method="POST" action="joinPro.jsp">
			<table border="1">
				<tr>
					<td>회원번호(자동생성)</td>
					<td><input type="text" id="custno" name="custno" value="<%=custno%>" readonly/></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="custnanme" name="custnanme"  required /></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" id="phone" name="phone"  required /></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="address" name="address"  required /></td>
				</tr>
				<tr>
					<td>가입날짜</td>
					<td><input type="date" id="joindate" name="joindate"  required /></td>
				</tr>
				<tr>
					<td>고객등급</td>
					<td>
						<select id="grade" name="custno" >
							<option value="A">A (VIP)</option>
							<option value="B">B (일반)</option>
							<option value="C">C (직원)</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" id="city" name=""city""  /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록" />
						<input type="button" value="조회" />
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>