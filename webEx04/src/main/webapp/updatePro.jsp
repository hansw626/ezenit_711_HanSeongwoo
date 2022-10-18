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
request.setCharacterEncoding("UTF-8");
int custno = Integer.parseInt(request.getParameter("custno"));
String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String data = request.getParameter("joindate");
String grade = request.getParameter("grade");
String city = request.getParameter("city");

MemberDao memberDao = MemberDao.getInstance();
MemberDto member = memberDao.getMember(custno);
if(custname != null)
	member.setCustname(custname);
if(phone != null)
	member.setPhone(phone);
if(address != null)
	member.setAddress(address);
if(data != null){
	String[] temp = data.split("-");
	int year = Integer.parseInt(temp[0]);
	int month = Integer.parseInt(temp[1]);
	int day = Integer.parseInt(temp[2]);
	Date date = new Date(year-1900, month, day);
	Timestamp joindate = new Timestamp(date.getTime());
	member.setJoindate(joindate);
}
if(grade != null)
	member.setGrade(grade);
if(city != null)
	member.setCity(city);
memberDao.updateMember(member);
response.sendRedirect("list.jsp");
%>
</body>
</html>