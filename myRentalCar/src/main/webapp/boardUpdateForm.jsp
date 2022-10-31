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
    <title>EZEN BOARD</title>
</head>
<body>
    <%
	BoardDao dao = BoardDao.getInstance();
	BoardDto board = null;
	
	request.setCharacterEncoding("utf-8");
	if(request.getParameter("no") != null) {
		int no = Integer.parseInt(request.getParameter("no"));
		board = dao.getBoardByNo(no); %>

    <h1>EZEN BOARD</h1>
    <div class="form-container">
        <form method="post" action="boardUpdater">
        	<input type="hidden" name="no" value="<%=no%>">
            <input type="text" name="title" value="<%=board.getTitle() %>">
            <textarea name="content" rows="20"><%=board.getContent() %></textarea>
            <input type="submit" value="수정하기">
        </form>
    </div>
	<%}
	else {
		response.sendRedirect("cummunity"); //borad 조회 실패 -> 페이지 이
	}%>
	
</body>
</html>