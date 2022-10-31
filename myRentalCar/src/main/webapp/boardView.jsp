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
<link rel="stylesheet" href="resources/form.css">
<title>EZEN RENTAL CAR</title>
</head>
<body>
	<%
	BoardDao dao = BoardDao.getInstance();
	BoardDto board = null;
	
	request.setCharacterEncoding("utf-8");
	if(request.getParameter("no") != null) {
		int no = Integer.parseInt(request.getParameter("no"));
		board = dao.getBoardByNo(no); 
		dao.countView(no);
		%>
	<div class="container">
		<jsp:include page="header.jsp" />
		<section>
			<h1>게시글 작성</h1>
			<h1>EZEN BOARD</h1>
			<div class="form-container">
				<form method="post" action="">
					<input type="text" value="<%=board.getTitle() %>" readonly>
					<textarea rows="20" readonly><%=board.getContent() %></textarea>
					<input type="button" onclick="location.href='cummunity'" value="글목록">
					<% 
					String log = (String)session.getAttribute("log");
					if(log!=null && log.equals(board.getUser())){
					%>
					<input type="button"
						onclick="location.href='boardUpdate?no=<%=board.getNo() %>'"
						value="글수정"> <input type="button"
						onclick="location.href='boardDelete?no=<%=board.getNo() %>'"
						value="글삭제">
					<%} %>
				</form>
			</div>
		</section>
		<jsp:include page="footer.jsp" />
	</div>
	<%}
	else {
		response.sendRedirect("index"); //borad 조회 실패 -> 페이지 이
	}%>
</body>
</html>