<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/grid.css">
	<script src="https://kit.fontawesome.com/0199e87f85.js" crossorigin="anonymous"></script>
    <title>EZEN RENTAL CAR</title>
</head>
<body>

    <header>
        <h1>EZEN RENTAL CAR</h1>
        <div class="login_box">
        	<%if(session.getAttribute("log")==null){ %>
        		<a href="login.jsp">로그인</a>
        	<%} else {
        		%>
        		<a href="logout">로그아웃</a>
        	<%} %>
        </div>
    </header>
    <nav>
        <ul>
            <li><a href="guide">서비스안내</a></li>
            <li><a href="rentalPage">차량대여</a></li>
            <li><a href="board">커뮤니티</a></li>
            <li><a href="notice">공지사항</a></li>
            <li><a href="move?page=mypage">마이페이지</a></li>
        </ul>
    </nav>
    <aside>
        광고이미지
    </aside>
</body>
</html>