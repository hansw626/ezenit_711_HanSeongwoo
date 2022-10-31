<%@page import="notice.NoticeDto"%>
<%@page import="notice.NoticeDao"%>
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
	NoticeDao dao = NoticeDao.getInstance();
	NoticeDto notice = null;
	
	request.setCharacterEncoding("utf-8");
	
	if(request.getParameter("no") != null) {
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		notice = dao.getNoticeByNo(no); 
		dao.countView(no);
		%>
	<div class="container">
		<jsp:include page="header.jsp" />
		<section>
			<h1>게시글 작성</h1>
			<h1>EZEN BOARD</h1>
			<div class="form-container">
				<form method="post" action="">
					<input type="text" value="<%=notice.getTitle() %>" readonly>
					<textarea rows="20" readonly><%=notice.getContent() %></textarea>
					<input type="button" onclick="location.href='notice'" value="글목록">
					<% 
					String log = (String)session.getAttribute("log");
					if(log!=null && log.equals(notice.getUser())){
					%>
					<input type="button"
						onclick="location.href='noticeUpdate?no=<%=notice.getNo() %>'"
						value="글수정"> <input type="button"
						onclick="location.href='noticeDelete?no=<%=notice.getNo() %>'"
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