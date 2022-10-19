<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="member.MemberDao"%>
<%@page import="member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDao memberDao = MemberDao.getInstance();

request.setCharacterEncoding("UTF-8");
int custno = Integer.parseInt(request.getParameter("custno"));
String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
Timestamp joindate = memberDao.getTimestamp(request.getParameter("joindate"));
String grade = request.getParameter("grade");
String city = request.getParameter("city");

MemberDto member = memberDao.getMember(custno);
if(custname != null)
	member.setCustname(custname);
if(phone != null)
	member.setPhone(phone);
if(address != null)
	member.setAddress(address);
if(joindate != null)
	member.setJoindate(joindate);
if(grade != null)
	member.setGrade(grade);
if(city != null)
	member.setCity(city);
memberDao.updateMember(member);
response.sendRedirect("list.jsp");
%>
</body>
</html>