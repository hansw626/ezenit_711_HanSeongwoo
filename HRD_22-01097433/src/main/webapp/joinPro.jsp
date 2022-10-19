<%@page import="member.MemberDao"%>
<%@page import="member.MemberDto"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
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
request.setCharacterEncoding("UTF-8");
int custno = Integer.parseInt(request.getParameter("custno"));
String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String[] str = request.getParameter("joindate").split("-");
int year = Integer.parseInt(str[0]);
int month = Integer.parseInt(str[1]);
int day = Integer.parseInt(str[2]);
Date date = new Date(year-1900,month,day);
Timestamp joindate = new Timestamp(date.getTime());
String grade = request.getParameter("grade");
String city = request.getParameter("city");

MemberDao memberDao = MemberDao.getInstance();
MemberDto member = new MemberDto(custno, custname, phone, address, joindate, grade, city);
boolean add = memberDao.addMember(member);

if(add){
	response.sendRedirect("list.jsp");
}else{
	response.sendRedirect("join.jsp");
}
%>
</body>
</html>