<%@page import="java.sql.Timestamp"%>
<%@page import="car.CarDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="car.CarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/carSection.css" />
<title>Insert title here</title>
</head>
<body>
<body>
<%
CarDao dao = CarDao.getInstance();
ArrayList<CarDto> carList = dao.getCarList();
%>
    <div class="container">
        <jsp:include page="header.jsp" />
        <section>
            <%for(CarDto car : carList) {%>
            <article>
            	<div class="img_box">
            		<img src="<%=car.getImg()%>" />
            		<p class="yearly"><%=car.getYearly()%>연식</p>
            		<p class="kind"><%=car.getKind()%></p>
            		<p class="brand"><%=car.getBrand()%></p>
            	</div>
            	<div class="model"><a name="code" href="move?page=viewcar&code=<%=car.getCode()%>"><%=car.getModel()%></a></div>
            	
            </article>
            <%}%>
        </section>
        <jsp:include page="footer.jsp" />
    </div>
</body>
</body>
</html>