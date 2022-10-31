<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDto"%>
<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/table.css" />
    <title>EZEN RENTAL CAR</title>
</head>
<body>
<%
BoardDao dao = BoardDao.getInstance();
ArrayList<BoardDto> boardList = dao.getBoardAll();
%>
    <div class="container">
        <jsp:include page="header.jsp" />
        <section>
        	<h2>자유 게시판</h2>
            <table border="1">
            	<thead>
            		<tr>
	            		<th width="150px">작성자</th>
	            		<th width="200px">작성일</th>
	            		<th>제목</th>
	            		<th width="100px">조회수</th>
            		</tr>
            	</thead>
            	<tbody>
            		<%for(BoardDto board : boardList){ %>
           			<tr>
           				<td><%=board.getUser()%></td>
           				<td><%=board.getRegDate() %></td>
           				<td><a href="boardView?no=<%=board.getNo()%>"><%=board.getTitle()%></a></td>
           				<td><%=board.getViewCnt() %></td>
           			</tr>
            		<%} %>
            	</tbody>
            </table>
            <form>
            
            </form>
             <button onclick="location.href='move?page=boardWrite'">글쓰기</button>
        </section>
        <jsp:include page="footer.jsp" />
    </div>
</body>
</html>