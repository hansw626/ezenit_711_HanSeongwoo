<%@page import="java.util.ArrayList"%>
<%@page import="rental.RentalVo"%>
<%@page import="rental.RentalDao"%>
<%@page import="user.UserDto"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/mypage.css" />
    <title>EZEN RENTAL CAR</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("log");
	UserDao userDao = UserDao.getInstance();
	UserDto user = userDao.getUserById(id);
	RentalDao rentalDao = RentalDao.getInstance();
	//ArrayList<RentalDto> rentalInfo = rentalDao.getUserRentalInfoAll(id);
%>
    <div class="container">
        <jsp:include page="header.jsp" />
        <section>
            <h2><%=id%>님의 페이지</h2>
            <div class="info_container">
            	<h3>계정 정보</h3>
            	<div>
            		<p>닉네임</p>
            		<input type="text" value="<%=user.getName() %>" readonly />
            	</div>
            	<div>
            		<p>휴대전화</p>
            		<input type="text" value="<%=user.getPhone() %>" readonly />
            	</div>
            	<div>
            		<p>주소</p>
            		<input type="text" value="<%=user.getAddress() %>" readonly />
            	</div>
            	<div>
            		<p>가입일</p>
            		<input type="text" value="<%=user.getRegDate() %>" readonly />
            	</div>
            	<br />
            	<div>
            		<input type="button" value="계정 수정" readonly />
            		<input type="button" value="계정 삭제" onclick="location.href='deleteUser'" readonly />
            	</div>
            </div>
            <div class="rental_container">
            	<h3>렌탈 기록</h3>
            	<table border="1">
            		<thead>
            			<tr>
            				<th>대여일</th>
            				<th>모델명</th>
            				<th>대여 이유</th>
            				<th>대여 장소</th>
            				<th>주행 거리</th>
            				<th>대여 기간</th>
            			</tr>
            		</thead>
            		<tbody>
            			
            		</tbody>
            	</table>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
    </div>
</body>
</html>