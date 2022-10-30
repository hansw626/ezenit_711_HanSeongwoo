<%@page import="java.sql.Timestamp"%>
<%@page import="car.CarDto"%>
<%@page import="car.CarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/viewCar.css" />
    <title>EZEN RENTAL CAR</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String code = request.getParameter("code");
CarDao dao = CarDao.getInstance();
CarDto car = dao.getCarByCode(code);
%>
    <div class="container">
        <jsp:include page="header.jsp" />
        <section>
        	<article>
	            <table border="1">
	            	<tr>
	            		<td rowspan=7 width="300px"><img src="<%=car.getImg()%>" /></td>
	            		<td width="100px">제조사</td>
	            		<td><%=car.getBrand()%></td>
	            	</tr>
	            	<tr>
	            		<td>차종</td>
	            		<td><%=car.getKind()%></td>
	            	</tr>
	            	<tr>
	            		<td>모델명</td>
	            		<td><%=car.getModel()%></td>
	            	</tr>
	            	<tr>
	            		<td>연식</td>
	            		<td><%=car.getYearly()%></td>
	            	</tr>
	            	<tr>
	            		<td>연료</td>
	            		<td><%=car.getFuel()%></td>
	            	</tr>
	            	<tr>
	            		<td>주행비용(km)</td>
	            		<td><%=car.getCost()%>원</td>
	            	</tr>
	            	<tr>
	            		<td>랜트비용</td>
	            		<td><%=car.getPrice()%>원</td>
	            	</tr>
	            </table>
            </article>
            <article class="rental">
            	<h2>랜트카 신청하기</h2>
            	<form method="POST" action="rental">
            		<input type="hidden" name="code" value="<%=car.getCode()%>" />
            		<input type="hidden" name="cost" value="<%=car.getCost()%>" />
            		<input type="hidden" name="price" value="<%=car.getPrice()%>" />
            		<div class="input_box">
            			<p>대여일</p>
            			<input type="date" name="start_date" />
            		</div>
            		<div class="input_box">
            			<p>대여 종료일</p>
            			<input type="date" name="end_date" />
            		</div>
            		<div class="input_box">
            			<p>대여장소</p>
            			<select name="area">
            				<option>인천공항</option>
            				<option>김포공항</option>
            				<option>청주공항</option>
            				<option>제주도공항</option>
            			</select>
            		</div>
            		<div class="input_box">
            			<p>신청사유</p>
            			<input type="text" name="reason" placeholder="랜트 종료일" />
            		</div>
            		<div class="input_box">
            			<input type="submit" name="end_date" value="신청하기" />
            		</div>
            	</form>
            </article>
        </section>
        <jsp:include page="footer.jsp" />
    </div>
</body>
</html>